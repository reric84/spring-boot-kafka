package com.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }

    @KafkaListener(id = "fooGroup", topics = "topic1")
    public void listen(String in) {
        logger.info("Received: " + in);
        if (in.startsWith("foo")) {
            throw new RuntimeException("failed");
        }
    }

    @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
    public void dltListen(String in) {
        logger.info("Received from DLT: " + in);
    }

}
