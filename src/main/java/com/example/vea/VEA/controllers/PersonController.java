package com.example.vea.VEA.controllers;

import com.example.vea.VEA.models.Person;
import com.example.vea.VEA.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/persons")
    public String persons(){
        return "persons";
    }

    @GetMapping(path = "/persons/create")
    public String createPerson(Model model){
        model.addAttribute("person", new Person());
        return "create-person";
    }

    @PostMapping(path = "/persons/create")
    public String insertPerson(@ModelAttribute Person person){
        personService.insertPerson(person);
        return "redirect:/persons";
    }

    @GetMapping(path = "/persons/{id}/edit")
    public String editPerson(@PathVariable int id, Model model){
        model.addAttribute("person", personService.getById(id));
        model.addAttribute("id", id);
        return "edit-person";
    }

    @PostMapping(path = "/persons/{id}/edit")
    public String updatePerson(@PathVariable int id, @ModelAttribute Person person){
        person.setId(id);
        personService.updatePerson(person);
        return "redirect:/persons";
    }

    @ModelAttribute(name = "persons")
    public List<Person> getPersons(){
        return personService.all();
    }
}
