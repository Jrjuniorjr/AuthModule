package com.example.authmodule.models;

import java.util.List;

public class MessageAWS {

    public String access;
    public String secret;
    public String topic;
    public String message;
    public List<String> phones;

    public MessageAWS(String access, String secret, String topic, String message, List<String> phones) {
        this.access = access;
        this.secret = secret;
        this.topic = topic;
        this.message = message;
        this.phones = phones;
    }
}
