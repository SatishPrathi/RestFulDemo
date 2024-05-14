package restapidemo

class UrlMappings {

    static mappings = {
        // Other mappings...

        // Mapping for login endpoint
        "/api/login"(controller: 'user', action: 'login')

        // Default mappings
        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
