package com.youtube.jwt.controller;

import com.youtube.jwt.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/sendMessage")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<String> publishMessage(@RequestBody Message systemMessage) {
        try {
            jmsTemplate.convertAndSend("Mai Van Truong", systemMessage);

            return new ResponseEntity<>("Sent.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
