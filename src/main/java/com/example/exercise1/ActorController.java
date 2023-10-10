package com.example.exercise1;

import jakarta.validation.Valid;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;
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
    @GetMapping("/{id}")
    public ResponseEntity<Actor> detailUser(@PathVariable (value = "id") String id,@RequestBody Actor actorDetails) {
        int actorId;
        try {
            actorId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }

        final Actor updatedUser = actorServices.detailActor(actorId);
        return ResponseEntity.ok(updatedUser);
}
    @PostMapping("")
    public Actor addActor(@RequestBody Actor theActor){
        theActor.setActorId(0);
        Date date=new Date();
        theActor.setLastUpdate(new Timestamp(date.getTime()));
        Actor dbActor = actorServices.saveActor(theActor);
        return dbActor;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateUser(@PathVariable (value = "id") String id,@RequestBody Actor actorDetails){
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
            throw new AppException(404, HttpStatus.NOT_FOUND, "User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
