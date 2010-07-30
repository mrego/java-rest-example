package com.mastersoftwarelibre.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message-list")
public class MessageListDTO {

    @XmlElement(name = "message")
    public List<MessageDTO> messages;

    public MessageListDTO() {
    }

    public MessageListDTO(List<MessageDTO> messages) {
        this.messages = messages;
    }

}