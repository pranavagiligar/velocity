package com.velocity.service

import com.velocity.dao.UserDao
import com.velocity.db.doc.User
import com.velocity.security.service.UserDetailsImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userDao: UserDao

    fun isRequestFromSameUser(username: String) =
        (SecurityContextHolder.getContext().authentication.principal as UserDetailsImpl).username == username

    fun getUserDetail(userName: String): User?
            = userDao.findUserByUsername(userName)

    fun createUser(user: User): User
            = userDao.save(user)

    fun deleteUser(username: String): User?
            = userDao.deleteUserByUsername(username)

}