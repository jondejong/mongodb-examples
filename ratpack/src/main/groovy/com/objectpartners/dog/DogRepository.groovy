package com.objectpartners.dog

import com.gmongo.GMongo
import com.google.inject.Inject
import ratpack.exec.Blocking


/**
 * Created by jondejong on 9/16/15.
 */
class DogRepository {

    def database

    @Inject
    DogRepository(){
        database = new GMongo("127.0.0.1", 27017).getDB('doggies')
    }

    def getDogs() {
        Blocking.get({
            database.dogs.find().asList()
        })

    }
}
