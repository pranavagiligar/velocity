package com.velocity.security.service

import com.velocity.db.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserDetailsServiceImpl: UserDetailsService {
    @Autowired lateinit var userRepository: UserRepository
    @Transactional override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            .orElseThrow {
                UsernameNotFoundException("User not found with username: $username")
            }
        return UserDetailsImpl.build(user)
    }
}