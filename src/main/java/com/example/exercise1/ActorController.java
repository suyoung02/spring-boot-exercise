package com.example.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ActorController {
    private ActorServices actorServices;

    @Autowired
    public ActorController (ActorServices actorServices) {
        this.actorServices = actorServices;
    }

    @PostMapping("/actors")
    public Actor addActor(@RequestBody Actor theActor){
        theActor.setActorId(0);
        Date date=new Date();
        theActor.setLastUpdate(new Timestamp(date.getTime()));
        Actor dbActor = actorServices.saveActor(theActor);
        return dbActor;
    }

}
