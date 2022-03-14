package org.quarkusrest.exception;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.jboss.logging.Logger;
import org.quarkusrest.dto.baseResponse.CommonErrorResponse;
import org.quarkusrest.dto.baseResponse.Messages;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

@Provider
public class GlobalExceptionHandling implements ExceptionMapper<RuntimeException> {
    private static final Logger LOG=Logger.getLogger(GlobalExceptionHandling.class);
    @Override
    public Response toResponse(RuntimeException exception) {
        if(exception instanceof UserException) {
            LOG.info("UserException started");
            List<Messages> list = new ArrayList<>(((UserException) exception).getMessages());

            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponseBody(list))
                    .build();
        }

        if(exception instanceof CountryException){
            LOG.info("CountryException started");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponseBody(exception.getMessage()))
                    .build();
        }
        if(exception instanceof CustomException) {
            LOG.info("CustomException started");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponseBody(exception.getMessage()))
                    .build();
        }


        exception.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponseBody("Something unexpected happened. Try again"))
                .build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static final class ErrorResponseBody {
        private  String  errorMessage;
        private List<Messages> messages;

        public ErrorResponseBody(List<Messages> messages) {
            if(this.messages==null){
                this.messages=new ArrayList<>();
            }
            this.messages.addAll(messages);
        }

        public ErrorResponseBody(String message) {
            this.errorMessage = message;
        }


        public List<Messages> getMessages() {
            return messages;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
