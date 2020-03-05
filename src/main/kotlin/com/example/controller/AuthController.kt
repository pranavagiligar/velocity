package com.example.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import com.example.service.UserService
import org.springframework.web.bind.annotation.RestController

//@RestController
class AuthController {

//    @Autowired
//    lateinit var userService: UserService

    companion object {
        val TAG: String = this.javaClass.simpleName
    }
}