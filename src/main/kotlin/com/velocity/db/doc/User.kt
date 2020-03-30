package com.velocity.db.doc

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Document(collection = "users")
data class User(@Id var id: String?,
                var fullname: String,
                @NotBlank @Size(max = 50) @Email var email: String,
                @NotBlank @Size(max = 20) @Indexed var username: String,
                @NotBlank @Size(max = 120) var password: String,
                @DBRef var roles: HashSet<Role> = HashSet()
)