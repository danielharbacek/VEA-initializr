package com.example.vea.VEA.controllers;

import com.example.vea.VEA.services.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {

    @Autowired
    private Counter counter;

    @GetMapping("/counter")
    public String counter(Model model){
        model.addAttribute("name", counter.getName());
        return "counter";
    }
}
