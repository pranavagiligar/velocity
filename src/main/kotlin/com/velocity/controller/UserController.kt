package com.velocity.controller

import com.velocity.db.doc.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.velocity.service.UserService
import org.springframework.security.access.prepost.PreAuthorize

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or @userService.isRequestFromSameUser(#username)")
    fun getUserDetail(@PathVariable("username") username: String): Any =
        userService.getUserDetail(username) ?: mapOf("message" to "Not found")

    @PreAuthorize("hasRole('ROLE_ADMIN') or @userService.isRequestFromSameUser(#username)")
    @DeleteMapping("/{username}")
    fun deleteUser(@PathVariable("username") username: String): Any {
        userService.deleteUser(username)?.let {
            return it
        } ?: return mapOf("message" to "Not found")
    }

    @PatchMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN') or @userService.isRequestFromSameUser(#username)")
    fun patchUser(@RequestBody user: User): Any? {
        return mapOf("message" to "Under construction")
    }

    companion object {
        val TAG: String = UserController::javaClass.name
    }
}
