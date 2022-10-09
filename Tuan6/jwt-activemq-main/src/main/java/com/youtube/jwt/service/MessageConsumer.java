package com.youtube.jwt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.youtube.jwt.entity.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MessageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Message.class);

    @JmsListener(destination = "Mai Van Truong")
    public void messageListener(Message systemMessage) {
        LOGGER.info("Message received! {}", systemMessage);
    }
}
