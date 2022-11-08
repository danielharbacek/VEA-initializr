package com.example.vea.VEA.controllers;

import com.example.vea.VEA.models.Address;
import com.example.vea.VEA.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(path = "/addresses")
    public String addresses(){
        return "addresses";
    }

    @GetMapping(path = "/addresses/create")
    public String createAddress(Model model){
        model.addAttribute("address", new Address());
        return "create-address";
    }

    @PostMapping(path = "/addresses/create")
    public String insertAddress(@ModelAttribute Address address){
        addressService.insert(address);
        return "redirect:/addresses";
    }

    @GetMapping(path = "/addresses/{id}/edit")
    public String editAddress(@PathVariable int id, Model model){
        model.addAttribute("address", addressService.find(id));
        model.addAttribute("id", id);
        return "edit-address";
    }

    @PostMapping(path = "/addresses/{id}/edit")
    public String updateAddress(@PathVariable int id, @ModelAttribute Address address){
        address.setId(id);
        addressService.update(address);
        return "redirect:/addresses";
    }

    @ModelAttribute(name = "addresses")
    public List<Address> getAddresses(){
        return addressService.all();
    }
}
