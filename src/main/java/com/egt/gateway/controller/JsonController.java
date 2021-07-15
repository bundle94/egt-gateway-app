package com.egt.gateway.controller;

import com.egt.gateway.model.FindRequest;
import com.egt.gateway.model.InsertRequest;
import com.egt.gateway.model.ServerResponse;
import com.egt.gateway.service.JsonApiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class JsonController {
    private JsonApiServices jsonApiServices;

    @Autowired
    public JsonController(JsonApiServices jsonApiServices) {
        this.jsonApiServices = jsonApiServices;
    }

    @RequestMapping(value = "/json_api/insert", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> insert(@RequestBody @Validated InsertRequest request) {
        jsonApiServices.insert(request);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/json_api/find", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ServerResponse> find(@RequestBody FindRequest request) {
        ServerResponse response = jsonApiServices.find(request);
        return ResponseEntity.ok(response);
    }


}