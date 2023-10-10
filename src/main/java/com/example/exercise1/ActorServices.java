package com.example.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Actor updateActor(Actor actor, Actor actorDetails) {
        actor.setLastName(actorDetails.getLastName());
        actor.setFirstName(actorDetails.getFirstName());
        Date date = new Date();
        actor.setLastUpdate(new Timestamp(date.getTime()));
        actorRepository.save(actor);
        return actor;
    }
    public Actor detailActor(Actor actor) {
        actor.setLastName(actor.getLastName());
        actor.setFirstName(actor.getFirstName());
        actor.setLastUpdate(actor.getLastUpdate());
        actorRepository.save(actor);
        return actor;
    }
}
