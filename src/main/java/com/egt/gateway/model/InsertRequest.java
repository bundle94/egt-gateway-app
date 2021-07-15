package com.egt.gateway.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class InsertRequest {

    @NotBlank(message = "requestId is required")
    private String requestId;
    @NotBlank(message = "timestamp is required")
    private String timestamp;
    @NotBlank(message = "producerId is required")
    private String producerId;
    @NotBlank(message = "SessionId is required")
    private String sessionId;

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
