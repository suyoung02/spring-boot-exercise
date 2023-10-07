package com.example.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServices {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorServices(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

}
