package com.example.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ActorServices {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorServices(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    public Boolean deleteActorByID(Integer id){
        if(actorRepository.existsById(id)) {
            actorRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Actor updateActor(Actor actor, Actor actorDetails) {
        actor.setLastName(actorDetails.getLastName());
        actor.setFirstName(actorDetails.getFirstName());
        Date date = new Date();
        actor.setLastUpdate(new Timestamp(date.getTime()));
        actorRepository.save(actor);
        return actor;

    public Actor updateActor(Integer actorId, Actor actorDetails) {
        Actor actor = actorRepository.findByActorId(actorId);
        if (actor == null) {
            throw new AppException(404, HttpStatus.NOT_FOUND,"User not found");
        }
        actor.setLastName(actorDetails.getLastName());
        actor.setFirstName(actorDetails.getFirstName());
        Date date = new Date();
        actor.setLastUpdate(new Timestamp(date.getTime()));
        actorRepository.save(actor);
        return actor;

    public List<Actor> getAll() {
        return actorRepository.findAll();
    }
}
