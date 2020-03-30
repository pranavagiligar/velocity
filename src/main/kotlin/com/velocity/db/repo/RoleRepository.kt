package com.velocity.db.repo

import com.velocity.db.doc.Role
import com.velocity.model.ERole
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RoleRepository: MongoRepository<Role, String> {
    fun findByName(name: ERole): Optional<Role>
}