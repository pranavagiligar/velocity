package com.velocity.dao

import com.velocity.db.doc.User
import com.velocity.db.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserDao {

    @Autowired
    lateinit var userRepository: UserRepository

    fun findUserByUsername(username: String): User? = userRepository.findByUsername(username).orElse(null)
    fun deleteUserByUsername(username: String): User? {
        val user = userRepository.findByUsername(username).orElse(null)
        user?.let {
            userRepository.removeUserByUsername(username)
            return user
        } ?: return null
    }

    fun save(user: User): User {
        return userRepository.save(user)
    }
}