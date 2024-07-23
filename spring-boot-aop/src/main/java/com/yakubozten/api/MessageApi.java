package com.yakubozten.api;

import com.yakubozten.service.MessageService;
import com.yakubozten.service.IkincimMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired
    private MessageService messageService;
    @Autowired
    private IkincimMessageService i̇kincimMessageService;
    @PostMapping
    public ResponseEntity<String> ornekMethod(@RequestBody String message){
        i̇kincimMessageService.mesaj(message);
        return  ResponseEntity.ok(messageService.mesajVer(message));
    }
}
