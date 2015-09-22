class UrlMappings {
	static mappings = {

		"/dogs"(resources: 'dog')

//        "/$controller/$action?/$id?(.$format)?"{
//            constraints {
//                // apply constraints here
//            }
//        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
