package com.example.exercise1.Controller;

import com.example.exercise1.Service.ActorServices;
import com.example.exercise1.Exception.AppException;
import com.example.exercise1.Model.Actor;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.*;


@RestController
@RequestMapping(value = "/api/actors")
public class ActorController {
    private final ActorServices actorServices;

    @Autowired
    public ActorController (ActorServices actorServices) {
        this.actorServices = actorServices;
    }
  
    @GetMapping("")
    public List<Actor> getAll() {
        return actorServices.getAll();
    }

    @Operation(summary = "Find book by ID", description = "Returns a single book", tags = { "book" })
    @GetMapping("/{id}")
    public ResponseEntity<Actor> detailUser(@PathVariable (value = "id") String id) {
        int actorId;
        Actor a = new Actor();
        try {
            actorId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        final Actor updatedUser = actorServices.detailActor(actorId);
        return ResponseEntity.ok(updatedUser);
}
    @PostMapping()
    public Actor addActor(@Valid @RequestBody Actor theActor){
        System.out.println("abc");
        theActor.setActorId(0);
        Date date=new Date();
        theActor.setLastUpdate(new Timestamp(date.getTime()));
        Actor dbActor = actorServices.saveActor(theActor);
        return dbActor;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateUser(@PathVariable (value = "id") String id,@Valid @RequestBody Actor actorDetails){
        int actorId;
        try {
            actorId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }

        final Actor updatedUser = actorServices.updateActor(actorId, actorDetails);
        return ResponseEntity.ok(updatedUser);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable(value = "id") String id){
        int actorId;
        try {
            actorId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }
        if(!actorServices.deleteActorByID(actorId)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Djt me may");
        }
        return ResponseEntity.status(400).body("Deleted");
    }
}
