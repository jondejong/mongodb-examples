package com.jondejong.mongo

import org.bson.types.ObjectId

/**
 * Created by jondejong on 9/19/15.
 */
class DocumentConverter<T> {

    static def convert(Object object) {
        object.properties.findAll { !['class', 'metaClass'].contains(it.key) }
    }

}
