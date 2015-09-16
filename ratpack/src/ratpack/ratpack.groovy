import com.fasterxml.jackson.databind.ObjectMapper
import com.objectpartners.dog.DogRepository
import com.objectpartners.jackson.ObjectIdObjectMapper

import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json

ratpack {
    bindings {
        bind DogRepository
        add(ObjectMapper.class, new ObjectIdObjectMapper())
    }

    handlers {
        all {
            response.headers.add 'Access-Control-Allow-Origin', '*'
            response.headers.add 'Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE'
            response.headers.add 'Access-Control-Allow-Headers', 'Content-Type,X-Requested-With'
            next()
        }
        get {
            render 'Hello World'
        }
        get('dogs') {DogRepository dogRepository ->
            dogRepository.getDogs().then({dogs->
                render json(dogs)
            })
        }
    }
}
