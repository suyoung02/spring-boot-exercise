package com.example.exercise1;

import jakarta.validation.Valid;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping(value = "/api/actor")
public class ActorController {
    private final ActorServices actorServices;
    @Autowired
    public ActorController (ActorServices actorServices) {
        this.actorServices = actorServices;
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
}
