package com.example.vea.VEA.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping(path = "/{name}")
    public String index(@PathVariable String name, Model model){
        model.addAttribute("greeting", "Hello World");
        model.addAttribute("name", name);
        return "index";
    }
}
