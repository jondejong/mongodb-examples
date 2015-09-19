package com.jondejong.dog

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.bson.types.ObjectId

/**
 * Created by jondejong on 9/19/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Dog {
    ObjectId id
    String name
    Integer age
    String breed

    @Override
    String toString() {
        "${name}. ${age} year old ${breed}."
    }
}
