package org.quarkusrest.dto.baseResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jboss.logging.Logger;
import org.quarkusrest.controller.UserController;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonErrorResponse {
    private List<Messages> messages;
    private static final Logger LOG= Logger.getLogger(UserController.class);

    public CommonErrorResponse() {
        LOG.info("Common error response constructor started");
    }

    public CommonErrorResponse(List<Messages> messages) {
        this.messages = messages;
    }
    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public void addMessage(Messages messages){
        if(this.messages==null){
            this.messages=new ArrayList<>();
        }
        this.messages.add(messages);
    }
}
