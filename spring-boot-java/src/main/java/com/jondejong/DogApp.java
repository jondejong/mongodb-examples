package com.jondejong;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jondejong.jackson.ObjectIdObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jondejong on 9/19/15.
 */
@SpringBootApplication
@ComponentScan({"com.jondejong.controllers",
                "com.jondejong",
                "com.jondejong.repositories",
                "com.jondejong.filters"
})
public class DogApp {

    public static void main(String[] args) {
        SpringApplication.run(DogApp.class, args);
    }

    @Bean
    public ObjectMapper objectMapper () {
        return new ObjectIdObjectMapper();
    }
}




