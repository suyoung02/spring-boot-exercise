package com.example.exercise1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/actor")
public class ActorController {
    private final ActorServices actorServices;
    private final ActorRepository actorRepository;
    @Autowired
    public ActorController (ActorServices actorServices, ActorRepository actorRepository) {
        this.actorServices = actorServices;
        this.actorRepository = actorRepository;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateUser(@PathVariable (value = "id") Integer id,@RequestBody Actor actorDetails) {
        Actor actor = actorRepository.findByActorId(id);
        if (actor == null) {
            throw new AppException(404, HttpStatus.NOT_FOUND,"User not found");

        }
        final Actor updatedUser = actorServices.updateActor(actor, actorDetails);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable(value = "id") Integer id){
        if(!actorServices.deleteActorByID(id)){
            throw new AppException(404, HttpStatus.NOT_FOUND, "User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

}
