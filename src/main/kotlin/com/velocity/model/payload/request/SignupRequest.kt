package com.velocity.model.payload.request

import com.velocity.model.ERole
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SignupRequest(
    @NotBlank @Size(min = 3, max = 20) val fullname: String,
    @NotBlank @Size(min = 3, max = 20) val username: String,
    @NotBlank @Size(max = 50) @Email val email: String,
    @NotBlank @Size(min = 6, max = 40) val password: String,
    val roles: Set<ERole>?
)