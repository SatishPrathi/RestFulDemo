package com.demo

import grails.rest.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class LogincontrollerController extends RestfulController {

    static responseFormats = ['json', 'xml']

    def springSecurityService

    LogincontrollerController() {
        super(AppUser)
    }

    def authenticate() {
        def authentication = springSecurityService.authenticate(params.username, params.password)
        if (authentication) {
            def token = springSecurityService.createAuthToken(authentication)
            render(status: 200, text: "Authentication successful", contentType: "text/plain")
        } else {
            render status: 401
        }
    }
}
