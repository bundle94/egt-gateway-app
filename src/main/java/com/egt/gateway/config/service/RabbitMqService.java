package com.egt.gateway.config.service;


import com.egt.gateway.model.InsertRequest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class RabbitMqService {

    private AmqpTemplate rabbitTemplate;

    @Autowired
    public RabbitMqService(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${egt.gateway.rabbitmq.exchange}")
    private String exchange;

    @Value("${egt.gateway.rabbitmq.routingkey}")
    private String routingkey;

    public void send(InsertRequest request) {
        rabbitTemplate.convertAndSend(exchange, routingkey, request);
        System.out.println("Send msg = " + request);

    }
}
