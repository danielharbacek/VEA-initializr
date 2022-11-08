package com.example.vea.VEA.repositories.JPA;

import com.example.vea.VEA.models.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AddressRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Address> all(){
        return em.createQuery("select a from Address a", Address.class).getResultList();
    }

    public Address find(long id){
        return em.find(Address.class, id);
    }

    @Transactional
    public void insert(Address address){
        em.persist(address);
    }

    @Transactional
    public void update(Address address){
        em.merge(address);
    }
}
