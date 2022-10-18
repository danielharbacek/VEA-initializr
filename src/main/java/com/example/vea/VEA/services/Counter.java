package com.example.vea.VEA.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Service
public class Counter {

    private static int id = 0;
    private final String name;

    public Counter() {
        id++;
        name = "Counter:" + id;
    }
    public String getName() {
        return name;
    }
}
