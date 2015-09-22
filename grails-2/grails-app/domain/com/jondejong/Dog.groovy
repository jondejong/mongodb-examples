package com.jondejong

import org.bson.types.ObjectId

class Dog {

    ObjectId id

    String name
    String breed
    Integer age

    static mapping = {
        collection "dogs"
    }
}
