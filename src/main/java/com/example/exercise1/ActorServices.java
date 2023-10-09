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

    public Actor detailActor(Actor actor) {
        actor.setLastName(actor.getLastName());
        actor.setFirstName(actor.getFirstName());
        actor.setLastUpdate(actor.getLastUpdate());
        actorRepository.save(actor);
        return actor;
    }
}
