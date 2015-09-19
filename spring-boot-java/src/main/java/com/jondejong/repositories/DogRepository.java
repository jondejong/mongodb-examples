package com.jondejong.repositories;


import com.jondejong.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DogRepository extends MongoRepository<Dog, String> {

    public List<Dog> findByName(String lastName);

}