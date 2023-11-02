package com.example.exercise1.Controller;

import com.example.exercise1.Service.ActorServices;
import com.example.exercise1.Exception.AppException;
import com.example.exercise1.Model.Actor;
import jakarta.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.*;


@RestController
@RequestMapping(value = "/api/actors")
public class ActorController {
    private static final Logger logger = Logger.getLogger(ActorController.class);

    private final ActorServices actorServices;

    @Autowired
    public ActorController (ActorServices actorServices) {
        this.actorServices = actorServices;
    }
  
    @GetMapping("")
    public List<Actor> getAll() {
        logger.info("Get all actor in db");
        return actorServices.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> detailUser(@PathVariable (value = "id") String id) {
        int actorId;
        logger.info("Access API get details actor");
        try {
            actorId = Integer.parseInt(id);
            logger.info("Parsing string id to integer");
        } catch (NumberFormatException e) {
            logger.error("id should be integer");
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }
        String msg = String.format("return detail info of actor %d", actorId);
        logger.info(msg);
        final Actor updatedUser = actorServices.detailActor(actorId);
        return ResponseEntity.ok(updatedUser);
}
    @PostMapping()
    public Actor addActor(@Valid @RequestBody Actor theActor){
        logger.info("Add new actor to database");
        System.out.println("abc");
        theActor.setActorId(0);
        Date date=new Date();
        theActor.setLastUpdate(new Timestamp(date.getTime()));
        Actor dbActor = actorServices.saveActor(theActor);
        String msg = String.format("Add new actor %d to database", dbActor.getActorId());
        logger.info(msg);
        return dbActor;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateUser(@PathVariable (value = "id") String id,@Valid @RequestBody Actor actorDetails){
        int actorId;
        try {
            logger.info("Parsing id to integer");
            actorId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            logger.error("id should be integer");
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }

        final Actor updatedUser = actorServices.updateActor(actorId, actorDetails);
        String msg = String.format("Update actor %d success", actorId);
        logger.info(msg);
        return ResponseEntity.ok(updatedUser);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable(value = "id") String id){
        int actorId;
        try {
            logger.info("Parsing id to integer");
            actorId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            logger.error("id should be integer");
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }
        if(!actorServices.deleteActorByID(actorId)){
            String msg = String.format("Actor id %d not found", actorId);
            logger.error(msg);
            throw new AppException(404, HttpStatus.NOT_FOUND, "User not found");
        }
        logger.info("Deleted user");
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
