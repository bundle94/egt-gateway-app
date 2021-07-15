package com.egt.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;

public class FindRequest {

    @NotBlank(message = "RequestId is required")
    private String requestId;
    @NotBlank(message = "SessionId is required")
    private String sessionId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
