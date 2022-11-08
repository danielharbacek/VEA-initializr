package com.example.vea.VEA.services;

import com.example.vea.VEA.models.Address;
import com.example.vea.VEA.repositories.JPA.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> all(){
        return addressRepository.all();
    }

    public List<Address> allWithEmpty(){
        List<Address> addresses = addressRepository.all();
        addresses.add(0, new Address());
        return addresses;
    }

    public Address find(long id){
        return addressRepository.find(id);
    }

    public void insert(Address address){
        addressRepository.insert(address);
    }

    public void update(Address address){
        addressRepository.update(address);
    }
}
