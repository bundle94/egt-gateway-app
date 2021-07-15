package com.egt.gateway.service;

import com.egt.gateway.model.FindRequest;
import com.egt.gateway.model.InsertRequest;
import com.egt.gateway.model.ServerResponse;

public interface JsonApiServices {
    void insert(InsertRequest request);
    ServerResponse find(FindRequest request);
    void callInternalService(String request) throws Exception;
}
