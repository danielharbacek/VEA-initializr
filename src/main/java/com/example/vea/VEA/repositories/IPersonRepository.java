package com.example.vea.VEA.repositories;


import com.example.vea.VEA.models.Person;

import java.util.List;

public interface IPersonRepository {

    List<Person> getAll();
    void insertPerson(Person person);
    void updatePerson(Person person);
    Person findById(long id);
}
