import com.fasterxml.jackson.databind.ObjectMapper
import com.jondejong.dog.Dog
import com.jondejong.dog.DogRepository
import com.jondejong.jackson.ObjectIdObjectMapper
import org.bson.types.ObjectId

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

        get() {
            render json([
                    message: 'Invalid path. API starts with /dogs'
            ])
        }

        path('dogs') { DogRepository dogRepository ->
            byMethod {
                get {
                    dogRepository.getDogs().then { dogs ->
                        render json(dogs)
                    }
                }
                post {
                    parse(Dog).then { dog ->
                        dogRepository.saveDog(dog).then {
                            def message = "${dog.name} has been saved."
                            render json([message: message.toString()])
                        }
                    }
                }
            }

        }

        path('dogs/:id') { DogRepository dogRepository ->
            def id = new ObjectId(pathTokens.id)
            byMethod {
                get {
                    dogRepository.getDog(id).then { dog ->
                        render json(dog)
                    }
                }
                delete {
                    dogRepository.delete(id).then {
                        render json([message: 'Dog has been deleted'])
                    }
                }
                put {
                    parse(Dog).then { dog ->
                        dog.id = id
                        dogRepository.update(dog).then {
                            def message = "${dog.name} has been updated."
                            render json([message: message.toString()])
                        }
                    }
                }
            }
        }
    }

}
