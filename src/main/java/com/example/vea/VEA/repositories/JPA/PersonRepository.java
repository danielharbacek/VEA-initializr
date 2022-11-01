package com.example.vea.VEA.repositories.JPA;

import com.example.vea.VEA.models.Address;
import com.example.vea.VEA.models.Person;
import com.example.vea.VEA.repositories.IPersonRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> getAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Override
    @Transactional
    public void insertPerson(Person person) {
        em.persist(person);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        em.merge(person);
    }

    @Override
    public Person findById(long id) {
        return em.find(Person.class, id);
    }
}
