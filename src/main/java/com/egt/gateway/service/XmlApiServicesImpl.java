package com.egt.gateway.service;

import com.egt.gateway.config.service.RabbitMqService;
import com.egt.gateway.dto.model.Sessions;
import com.egt.gateway.dto.repository.SessionRepository;
import com.egt.gateway.dto.service.SessionService;
import com.egt.gateway.model.CommandRequest;
import com.egt.gateway.model.InsertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class XmlApiServicesImpl implements XmlApiServices {

    private SessionService sessionService;
    private RabbitMqService rabbitMqService;
    private SessionRepository sessionRepository;

    @Autowired
    public XmlApiServicesImpl(SessionService sessionService, RabbitMqService rabbitMqService,
                              SessionRepository sessionRepository) {
        this.sessionService = sessionService;
        this.rabbitMqService = rabbitMqService;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void command(CommandRequest request) {
        Sessions sessions = new Sessions(request.getId(), request.getEnter().getTimestamp(),
                request.getEnter().getPlayer(), request.getEnter().getSession());

        Optional<Sessions> session = sessionRepository.findByRequestId(request.getId());
        if(session.isEmpty()) {
            sessionService.saveSession(sessions);

            InsertRequest req = new InsertRequest();
            req.setRequestId(request.getId());
            req.setProducerId(request.getEnter().getPlayer());
            req.setTimestamp(request.getEnter().getTimestamp());
            req.setSessionId(request.getEnter().getSession());
            rabbitMqService.send(req);
        }
        else {
            System.out.println("Session already exists!");
        }
    }
}
