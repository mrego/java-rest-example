package com.mastersoftwarelibre.rest.entities;

public class Message {

    private String content;

    public Message(String content) {
        this.setContent(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}