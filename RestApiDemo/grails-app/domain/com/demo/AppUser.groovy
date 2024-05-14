package com.demo

import grails.compiler.GrailsCompileStatic
import org.springframework.security.core.userdetails.UserDetails

@GrailsCompileStatic
class AppUser implements UserDetails {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean credentialsExpired

    Set<SecurityRole> authorities

    static hasMany = [authorities: SecurityRole]

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
    }

    static mapping = {
        password column: '`password`'
    }

    // Implement UserDetails methods
    boolean isAccountNonExpired() {
        !accountExpired
    }

    boolean isAccountNonLocked() {
        !accountLocked
    }

    boolean isCredentialsNonExpired() {
        !credentialsExpired
    }

    boolean isEnabled() {
        enabled
    }
}
