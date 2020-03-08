package com.velocity.db.repo

import com.velocity.db.doc.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface  UserRepository: MongoRepository<User, String> {

    fun findUserByAuthority(authority: String): List<User>

    fun findUserById(id: String): User

    fun findUserByUsername(username: String): User?

    fun removeUserByUsername(username: String): Long
}