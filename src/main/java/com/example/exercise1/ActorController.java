package com.example.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/actors")
public class ActorController {
    private ActorServices actorServices;

    @Autowired
    public ActorController (ActorServices actorServices) {
        this.actorServices = actorServices;
    }

    @GetMapping("")
    public List<Actor> getAll() {
        return actorServices.getAll();
    }
}
