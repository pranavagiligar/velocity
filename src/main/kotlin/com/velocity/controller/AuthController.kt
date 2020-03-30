package com.velocity.controller

import com.velocity.db.doc.Role
import com.velocity.db.doc.User
import com.velocity.db.repo.RoleRepository
import com.velocity.db.repo.UserRepository
import com.velocity.model.ERole
import com.velocity.model.payload.request.LoginRequest
import com.velocity.model.payload.request.SignupRequest
import com.velocity.model.payload.response.JwtResponse
import com.velocity.model.payload.response.MessageResponse
import com.velocity.security.jwt.JwtUtility
import com.velocity.security.service.UserDetailsImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors
import javax.validation.Valid

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/auth")
class AuthController {

    @Autowired lateinit var authenticationManager: AuthenticationManager
    @Autowired lateinit var userRepository: UserRepository
    @Autowired lateinit var roleRepository: RoleRepository
    @Autowired lateinit var passwordEncoder: PasswordEncoder
    @Autowired lateinit var jwtUtility: JwtUtility

    @PostMapping("signin")
    fun authenticateUser(@Valid @RequestBody loginRequest: LoginRequest): ResponseEntity<Any>{
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)
        )

        SecurityContextHolder.getContext().authentication = authentication
        val jwt = jwtUtility.generateJwtToken(authentication)

        val userDetails = authentication.details as UserDetailsImpl
        val roles = userDetails.authorities.stream().map {
            item -> item.authority
        }.collect(Collectors.toList())

        return ResponseEntity.ok(JwtResponse(
            jwt,
            userDetails.mId,
            userDetails.username,
            userDetails.mEmail,
            roles
        ))
    }

    @PostMapping("/signup")
    fun registerUser(@Valid @RequestBody signupRequest: SignupRequest): ResponseEntity<Any> {
        signupRequest.apply {
            if(userRepository.existsByUsername(username)) {
                return ResponseEntity.badRequest().body(MessageResponse("Error: Username already taken"))
            }

            if(userRepository.existsByEmail(email)) {
                return ResponseEntity.badRequest().body(MessageResponse("Error: Email is already in use"))
            }

            val user = User(null, fullname, email, username, passwordEncoder.encode(password))

            val eRoles = this.roles
            val roles = HashSet<Role>()

            eRoles?.let {
                eRoles.forEach { role ->
                    when(role) {
                        ERole.ROLE_ADMIN -> {
                            val adminRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow {
                                    RuntimeException("Error: Role not found")
                                }
                            roles.add(adminRole)
                        }
                        ERole.ROLE_MODERATOR -> {
                            val modRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow {
                                    RuntimeException("Error: Role not found")
                                }
                            roles.add(modRole)
                        }
                        else -> {
                            val userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow {
                                    RuntimeException("Error: Role not found")
                                }
                            roles.add(userRole)
                        }
                    }
                }
            } ?: kotlin.run {
                val userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow {
                        RuntimeException("Error: Role not found")
                    }
                roles.add(userRole)
            }

            user.roles = roles
            userRepository.save(user)
            return ResponseEntity.ok(MessageResponse("User Registration successful"))
        }
    }

    companion object {
        val TAG: String = AuthController::javaClass.name
    }
}