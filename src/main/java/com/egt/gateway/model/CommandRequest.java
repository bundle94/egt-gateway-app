package com.egt.gateway.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class CommandRequest {
    @XmlAttribute(name = "id")
    @XmlID
    private String id;

    @XmlElement
    private Session enter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Session getEnter() {
        return enter;
    }

    public void setEnter(Session enter) {
        this.enter = enter;
    }

}
