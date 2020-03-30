package com.velocity.db.repo

import com.velocity.db.doc.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface  UserRepository: MongoRepository<User, String> {

    fun findByUsername(username: String): Optional<User>

    fun existsByUsername(username: String): Boolean

//    fun removeUserByUsername(username: String): Long

    fun existsByEmail(email: String): Boolean
}