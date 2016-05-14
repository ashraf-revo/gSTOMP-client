package com.bertramlabs.plugins.gstomp;

/**
 * Created by revo on 5/14/16.
 */
public class Message {
    private String content;
    private String from;
    private String to;

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public Message(String content, String from, String to) {
        this.content = content;
        this.from = from;
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public Message setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public Message setTo(String to) {
        this.to = to;
        return this;
    }
}
