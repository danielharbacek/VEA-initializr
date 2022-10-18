package com.example.vea.VEA.controllers;

import com.example.vea.VEA.models.Address;
import com.example.vea.VEA.models.Person;
import com.example.vea.VEA.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonApiController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/person")
    @ResponseBody
    public Person person(){
        return new Person(4, "first name", "last name", new Address("street", "city"));
    }

    @ResponseBody
    @GetMapping(path = "/persons")
    public List<Person> persons(){
        return personService.all();
    }
}
