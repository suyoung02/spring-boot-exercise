package com.example.exercise1.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
    private static Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
    @RabbitListener(queues={"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info(String.format("Receive sent ->%s",message));

    }
}
