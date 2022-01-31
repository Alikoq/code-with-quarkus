package org.quarkusrest.exception;

public class CustomException extends RuntimeException{
    private String message;
    private Integer code;
    public CustomException(String message, Integer code) {
        super(message);
        this.message=message;
        this.code=code;
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
