package com.chatbot.model;

public class Message {
    private String from;
    private String to;
    private String body;
    private String timestamp;
    private String type;

    public Message() {}

    public Message(String from, String to, String body, String timestamp, String type) {
        this.from = from;
        this.to = to;
        this.body = body;
        this.timestamp = timestamp;
        this.type = type;
    }

    // Getters and Setters
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
