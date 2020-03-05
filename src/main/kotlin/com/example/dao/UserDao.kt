package com.example.dao

import com.example.db.doc.User
import com.example.db.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserDao {

    @Autowired
    lateinit var userRepository: UserRepository

    fun findUserByUsername(username: String): User? = userRepository.findUserByUsername(username)
    fun deleteUserByUsername(username: String): User? {
        val user = userRepository.findUserByUsername(username)
        user?.let {
            userRepository.removeUserByUsername(username)
            return user
        } ?: return null
    }

    fun save(user: User): User {
        return userRepository.save(user)
    }
}