package com.youtube.jwt.controller;
import com.youtube.jwt.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Topic;
@Slf4j
@RestController
public class MessageTopicController {
    @Autowired
    JmsTemplate jmsTemplate;

    @PostMapping("/sendMsgTopic")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Message> newEmployee(@RequestBody Message message) {
        try {
            Topic empTopic = jmsTemplate.getConnectionFactory().createConnection()
                    .createSession().createTopic("messageTopic");
            Message msg = Message.builder().source(message.getSource()).message(message.getMessage()).build();
            log.info("Sending Message Object: " + msg);
            jmsTemplate.convertAndSend(empTopic, msg);
            return new ResponseEntity<>(msg, HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
