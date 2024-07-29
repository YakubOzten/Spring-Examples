package com.yakubozten;

import com.yakubozten.dto.Kmessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListenerService {

    @KafkaListener(
            topics = "${yakubozten.kafka.topic}",
            groupId = "${yakubozten.kafka.group.id}"
    )
    public  void  listen(Kmessage message){
        log.info("Message received .. MessageID : {} Message : {} Date {}",
                message.getId(),
                message.getMessage(),
                message.getMessageDate()
                );
    }

}
