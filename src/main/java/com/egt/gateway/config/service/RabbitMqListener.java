package com.egt.gateway.config.service;

import com.egt.gateway.config.AsyncConfiguration;
import com.egt.gateway.service.JsonApiServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncConfiguration.class);
    private JsonApiServices jsonApiServices;

    public RabbitMqListener() { }
    @Autowired
    public RabbitMqListener(JsonApiServices jsonApiServices) {
        this.jsonApiServices = jsonApiServices;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Consuming message - " + new String(message.getBody()));

        try {
            this.jsonApiServices.callInternalService(new String(message.getBody()));
        }
        catch (Exception e) {
            LOGGER.error("An error occurred while calling internal services " + e.getMessage());
        }
    }
}
