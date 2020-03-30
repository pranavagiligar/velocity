package com.velocity.security.jwt

import com.velocity.security.service.UserDetailsImpl
import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

import mu.KotlinLogging

import java.util.*
private val logger = KotlinLogging.logger {}

@Component
class JwtUtility {

    @Value(value = "\${com.velocity.jwtSecretKey}")
    private lateinit var jwtSecret: String

    @Value(value = "\${com.velocity.jwtExpirationMs}")
    private var jwtExpirationMs: Long = 0L

    fun generateJwtToken(authentication: Authentication): String {
        val userPrincipal = authentication.principal as UserDetailsImpl

        return Jwts.builder()
            .setSubject(userPrincipal.username)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().time + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact()
    }

    fun getUsernameFromJwtToken(token: String): String =
        Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body.subject

    fun validateJwtToken(authToken: String): Boolean {
        try {
            val jwsClaim = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
            if(jwsClaim.body.expiration.time > Date().time) {
//                TODO: if it is false then send custom object with expiration is true
                logger.info("JWT") { "Session expired: ${jwsClaim.body.subject}"; }
                return false
            }
            return true
        } catch (e: SignatureException) {
            logger.error(e) {  "Invalid JWT signature: ${e.message}" }
        } catch (e: MalformedJwtException) {
            logger.error(e) {  "Invalid JWT token: ${e.message}" }
        } catch (e: UnsupportedJwtException) {
            logger.error(e) {  "JWT token is unsupported: ${e.message}" }
        } catch (e: IllegalArgumentException) {
            logger.error(e) {  "JWT claim string is empty: ${e.message}" }
        }

        return false
    }
}