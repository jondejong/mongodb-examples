package com.jondejong.controllers;

import com.jondejong.Dog;
import com.jondejong.repositories.DogRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jondejong on 9/19/15.
 */
@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    DogRepository dogRepository;

    @RequestMapping(method=RequestMethod.GET)
    public List<Dog> list() {
        return dogRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST)
    public Map<String, String> save(@RequestBody Dog dog) {
        dogRepository.save(dog);
        Map<String, String> json = new HashMap<String, String>();
        json.put("message", dog.getName() + " was saved.");
        return json;
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public Map<String, String> delete(@PathVariable String id) {
        dogRepository.delete(id);
        Map<String, String> json = new HashMap<String, String>();
        json.put("message", "Dog was deleted.");
        return json;
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public  Map<String, String> update(@RequestBody Dog dog, @PathVariable String id) {
        dog.setId(new ObjectId(id));
        dogRepository.save(dog);
        Map<String, String> json = new HashMap<String, String>();
        json.put("message", dog.getName() + " was updated.");
        return json;
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public Dog fetch(@PathVariable String id) {
        return dogRepository.findOne(id);
    }
}
