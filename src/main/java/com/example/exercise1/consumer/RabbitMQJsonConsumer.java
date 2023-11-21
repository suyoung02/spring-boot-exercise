package com.example.exercise1.consumer;

import com.example.exercise1.Model.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service

public class RabbitMQJsonConsumer {
    private static Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
    @RabbitListener(queues={"${rabbitmq.queue.json.name}"})
    public void consume(Actor actor){
        LOGGER.info(String.format("Receive  Json message ->%s",actor.toString()));

    }
}
