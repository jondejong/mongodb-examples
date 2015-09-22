import grails.converters.JSON
import org.bson.types.ObjectId

class BootStrap {

    def init = { servletContext ->

        JSON.registerObjectMarshaller(ObjectId) {
            return it.toString();
        }
    }
    def destroy = {
    }
}
