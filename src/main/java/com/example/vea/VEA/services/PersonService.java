package com.example.vea.VEA.services;

import com.example.vea.VEA.models.Person;
import com.example.vea.VEA.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private IPersonRepository personRepository;

    public List<Person> all(){
        return personRepository.getAll();
    }

    public Person getById(int id){
        return personRepository.findById(id);
    }

    public void insertPerson(Person person){
        personRepository.insertPerson(person);
    }

    public void updatePerson(Person person){
        personRepository.updatePerson(person);
    }
}
