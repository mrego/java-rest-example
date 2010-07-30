package com.mastersoftwarelibre.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
public class MessageDTO {

    @XmlElement
    public String content;

    public MessageDTO() {
    }

    public MessageDTO(String content) {
        this.content = content;
    }

}