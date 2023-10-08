package com.example.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/actor")
public class ActorController {
    private ActorServices actorServices;

    @Autowired
    public ActorController (ActorServices actorServices) {
        this.actorServices = actorServices;
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable(value = "id") Integer id){
        if(actorServices.deleteActorByID(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can not find this id");
    }

}
