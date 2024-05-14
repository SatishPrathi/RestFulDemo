package restapidemo

import com.demo.SecurityRole
import com.demo.AppUser
import com.demo.UserSecurityRole

class BootStrap {

    // Inject necessary services for persistence
    def init = { servletContext ->
        // Create and save the initial data within a transactional block
        /*SecurityRole.withTransaction { transactionStatus ->
            // Create ROLE_USER security role
            def role = new SecurityRole(authority: 'ROLE_USER')
            if (!role.save(flush: true)) {
                role.errors.allErrors.each {
                    println it
                }
                // Rollback transaction if there's an error
                transactionStatus.setRollbackOnly()
                return
            }

            // Create AppUser
            def user = new AppUser(username: 'tom@gmail.com', password: 'timid1', enabled: true, accountExpired: false, accountLocked: false, credentialsExpired: false)
            if (!user.save(flush: true)) {
                user.errors.allErrors.each {
                    println it
                }
                // Rollback transaction if there's an error
                transactionStatus.setRollbackOnly()
                return
            }

            // Associate the user with the role
            UserSecurityRole.create(user, role)
        }*/
    }
}
