import com.fasterxml.jackson.databind.ObjectMapper
import com.jondejong.dog.DogRepository
import com.jondejong.jackson.ObjectIdObjectMapper
import org.bson.types.ObjectId

import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json
import static ratpack.jackson.Jackson.jsonNode

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

        path('dogs') {DogRepository dogRepository ->
            byMethod {
                get {
                    dogRepository.getDogs().then { dogs ->
                        render json(dogs)
                    }
                }
                post {
                    parse(jsonNode()).
                            then {dog ->
                                println "I think I parsed a dog ${dog}"
                                render json(dog)
//                                flatMap { input ->
//                                    render json(input)
//                                }
                            }



//                    def body = fromJson(Map, request.body.te)
                }
            }

        }

        get('dogs/:id') { DogRepository dogRepository ->
            def id = new ObjectId(pathTokens.id)
            dogRepository.getDog(id).then { dog ->
                render json(dog)
            }
        }
    }

}
