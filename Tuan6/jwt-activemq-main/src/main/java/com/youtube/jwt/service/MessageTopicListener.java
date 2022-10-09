package com.youtube.jwt.service;
import com.youtube.jwt.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageTopicListener {
    @JmsListener(destination = "${jsa.activemq.topic}", containerFactory = "msgJmsContFactory")
    public void getMessageListener1(Message message) {
        log.info("Message Listener 1: " + message);
    }
    @JmsListener(destination = "${jsa.activemq.topic}", containerFactory = "msgJmsContFactory")
    public void getMessageListener2(Message message) {
        log.info("Message Listener 2 " + message);
    }
}
