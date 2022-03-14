package org.quarkusrest.dto.baseResponse;

public class Messages {
    private String type;
    private String message;

    public Messages() {
    }

    public Messages(String message) {
        this.message = message;
    }

    public Messages(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
