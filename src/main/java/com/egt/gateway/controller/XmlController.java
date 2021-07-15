package com.egt.gateway.controller;

import com.egt.gateway.model.CommandRequest;
import com.egt.gateway.model.InsertRequest;
import com.egt.gateway.service.XmlApiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class XmlController {

    private XmlApiServices xmlApiServices;

    @Autowired
    public XmlController(XmlApiServices xmlApiServices) {
        this.xmlApiServices = xmlApiServices;
    }
    @RequestMapping(value = "/xml_api/command", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> command(@RequestBody @Validated CommandRequest request) {
        xmlApiServices.command(request);
        return ResponseEntity.ok().build();
    }
}
