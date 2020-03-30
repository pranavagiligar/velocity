package com.velocity.controller

import com.velocity.db.doc.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.velocity.service.UserService

//@RestController
//class UserController {
//
//    @Autowired
//    lateinit var userService: UserService
//
//    @PostMapping(path = ["/user"])
//    fun createUser(@RequestBody user: User): Any {
//        userService.getUserDetail(user.username)?.let {
//            return if(it.username == user.username) {
//                mapOf("message" to "Username already exists")
//            } else {
//                mapOf("message" to "Username can't be empty")
//            }
//        } ?: return userService.createUser(user)
//    }
//
//    @GetMapping(path = ["/user/{username}"])
//    fun getUserDetail(@PathVariable("username") username: String): Any
//        = userService.getUserDetail(username)?.let { it } ?: mapOf("message" to "Not found")
//
//    @DeleteMapping(path = ["/user/{username}"])
//    fun deleteUser(@PathVariable("username") username: String): Any {
//        userService.deleteUser(username)?.let {
//            return it
//        } ?: return mapOf("message" to "Not found")
//    }
//
//    @PatchMapping(path = ["/user"])
//    fun patchUser(@RequestBody user: User): Any? {
//        return mapOf("message" to "Under construction")
//    }
//
//    companion object {
//        val TAG: String = UserController::javaClass.name
//    }
//}
