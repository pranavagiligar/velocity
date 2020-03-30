package com.velocity.model.payload.response

import com.velocity.model.ERole

data class JwtResponse(
    val accessToken: String,
    val id: String?,
    val username: String,
    val email: String,
    val roles: List<String>
)