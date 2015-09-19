package com.jondejong.dog

import com.gmongo.GMongo
import com.google.inject.Singleton
import ratpack.exec.Blocking
import ratpack.server.Service
import ratpack.server.StartEvent
import ratpack.server.StopEvent


/**
 * Created by jondejong on 9/16/15.
 */
@Singleton
class DogRepository implements Service {

    GMongo mongo
    def database

    @Override
    void onStart(StartEvent event) throws Exception {
        println "Opening MongoDB Connection"
        mongo = new GMongo("127.0.0.1", 27017)
        database = mongo.getDB('doggies')
    }

    @Override
    void onStop(StopEvent event) throws Exception {
        println "Closing MongoDB Connection"
        mongo.close()
    }

    def getDogs() {
        Blocking.get {
            database.dogs.find().asList()
        }
    }

    def getDog(id) {
        Blocking.get {
            database.dogs.findOne([_id: id])
        }
    }

    def saveDog(dog) {
        Blocking.get {
            database.dogs << dog.properties.findAll { !['class', 'metaClass'].contains(it.key) }

        }
    }

    def delete(id) {
        Blocking.get {
            database.dogs.remove([_id: id])
        }
    }
}
