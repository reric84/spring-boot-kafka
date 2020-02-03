package com.demo.controllers;

import com.demo.engine.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopicUsers(@RequestParam("message") String message) {
        this.producer.sendMessageToUsers(message);
    }

    @PostMapping(value = "/publish-topic1")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessageToTopic1(message);
    }
}
