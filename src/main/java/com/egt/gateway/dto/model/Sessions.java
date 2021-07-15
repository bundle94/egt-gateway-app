package com.egt.gateway.dto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "sessions")
public class Sessions {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String requestId;
    private String timestamp;
    private String producerId;
    private String sessionId;

    public Sessions(String requestId, String timestamp, String producerId, String sessionId) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.producerId = producerId;
        this.sessionId = sessionId;
    }

    public Sessions () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
