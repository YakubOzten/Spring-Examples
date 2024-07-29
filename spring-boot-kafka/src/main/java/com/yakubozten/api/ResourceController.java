package com.yakubozten.api;


import com.yakubozten.dto.Kmessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/kmessage")
@RequiredArgsConstructor
public class ResourceController {


    @Value("${yakubozten.kafka.topic}")
    private  String topic;

    private final KafkaTemplate<String, Kmessage> kafkaTemplate;


    @PostMapping
    public void sendMessage(@RequestBody Kmessage kmessage){
        kafkaTemplate.send(topic, UUID.randomUUID().toString(),kmessage);
    }

}
