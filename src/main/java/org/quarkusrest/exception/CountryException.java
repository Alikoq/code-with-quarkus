package org.quarkusrest.exception;

import org.quarkusrest.dto.baseResponse.Messages;

import java.util.List;

public class CountryException extends RuntimeException{
    private String msg;

    public CountryException( String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
