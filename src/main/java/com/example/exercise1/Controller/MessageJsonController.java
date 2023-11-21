package com.example.exercise1.Controller;

import com.example.exercise1.Model.Actor;
import com.example.exercise1.publisher.RabbitMQJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/api/v1")

public class MessageJsonController {
    private RabbitMQJsonProducer jsonProducer;
    @Autowired

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Actor actor){
        Date date=new Date();
        actor.setLastUpdate(new Timestamp(date.getTime()));
        jsonProducer.sendJsonMessage(actor);
        return ResponseEntity.ok("Message sent to Rabbitmq");

    }
}
