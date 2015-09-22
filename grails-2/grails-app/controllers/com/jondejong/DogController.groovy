package com.jondejong

import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class DogController extends RestfulController<Dog> {

    static responseFormats = ['json']

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        respond Dog.list(params)
    }

    def show(Dog dogInstance) {
        respond dogInstance
    }

    @Transactional
    def save(Dog dogInstance) {
        if (dogInstance == null) {
            notFound()
            return
        }

        if (dogInstance.hasErrors()) {
            respond dogInstance.errors
            return
        }

        dogInstance.save flush:true

        def res = [message: "${dogInstance.name} has been saved"]
        respond res
    }

    def edit(Dog dogInstance) {
        respond dogInstance
    }

    @Transactional
    def update(Dog dogInstance) {
        if (dogInstance == null) {
            notFound()
            return
        }

        if (dogInstance.hasErrors()) {
            respond dogInstance.errors, view:'edit'
            return
        }

        dogInstance.save flush:true
        def res = [message: "${dogInstance.name} has been saved"]
        respond res
    }

    @Transactional
    def delete(Dog dogInstance) {

        if (dogInstance == null) {
            notFound()
            return
        }

        dogInstance.delete flush:true
        def res = [message: "dog has been saved"]
        respond res
    }

    protected void notFound() {
        render status: NOT_FOUND
    }
}
