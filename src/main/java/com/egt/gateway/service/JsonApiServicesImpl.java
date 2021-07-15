package com.egt.gateway.service;

import com.egt.gateway.config.service.RabbitMqService;
import com.egt.gateway.model.FindRequest;
import com.egt.gateway.model.InsertRequest;
import com.egt.gateway.model.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;

@Service
public class JsonApiServicesImpl implements JsonApiServices{

    private RabbitMqService rabbitMqService;

    @Autowired
    public JsonApiServicesImpl(RabbitMqService rabbitMqService)  {
        this.rabbitMqService = rabbitMqService;
    }

    @Override
    public void insert(InsertRequest request) {

        rabbitMqService.send(request);
    }

    @Override
    public ServerResponse find(FindRequest request) {
        return new ServerResponse();
    }

    @Override
    @Async
    public void callInternalService(String request) throws Exception{
        //Make call to postman echo
        HttpRequest req = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .GET()
                .build();

        System.out.println(req);
    }
}
