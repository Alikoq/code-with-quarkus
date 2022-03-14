package org.quarkusrest.exception;

import org.quarkusrest.dto.baseResponse.Messages;

import java.util.List;

public class UserException extends RuntimeException{
    private String msg;
    private List<Messages> messages;
    public UserException(String message) {
        super(message);
        this.msg=message;
    }

    public UserException(List<Messages> messages) {
        this.messages = messages;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }
}
