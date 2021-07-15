package com.egt.gateway.dto.service;

import com.egt.gateway.dto.model.Sessions;
import com.egt.gateway.dto.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private SessionRepository sessionRepository;

    @Autowired
    public SessionService (SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void saveSession(Sessions sessions) {
        sessionRepository.save(sessions);
    }

}
