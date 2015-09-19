package com.jondejong.dog

import com.sun.corba.se.spi.ior.ObjectId

/**
 * Created by jondejong on 9/19/15.
 */
class Dog {
    ObjectId id
    String name
    Integer age
    String breed

    @Override
    String toString() {
        return "${name}. ${age} year old ${breed}."
    }
}
