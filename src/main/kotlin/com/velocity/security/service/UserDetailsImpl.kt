package com.velocity.security.service

import com.fasterxml.jackson.annotation.JsonIgnore
import com.velocity.db.doc.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors

class UserDetailsImpl(val mId: String?, private val mUsername: String,
                      val mEmail: String, @JsonIgnore private val mPassword: String,
                      private val mAuthorities: Collection<GrantedAuthority>): UserDetails {
    private val serialVersionUID = 1L

    override fun getUsername(): String = mUsername

    override fun getPassword(): String = mPassword

    override fun getAuthorities(): Collection<GrantedAuthority> = mAuthorities

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other === null
            || javaClass != other.javaClass) return false
        val user = other as UserDetailsImpl

        return Objects.equals(mId, user.mId);
    }

    companion object {
        fun build(user: User): UserDetailsImpl {
            val authorities: List<GrantedAuthority> = user.roles.stream()
                .map { role -> SimpleGrantedAuthority(role.name.name) }
                .collect(Collectors.toList())

            return UserDetailsImpl(user.id, user.username, user.email, user.password, authorities)
        }
    }
}
