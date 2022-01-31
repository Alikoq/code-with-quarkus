package org.quarkusrest.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandling implements ExceptionMapper<Exception> {



    @Override
    public Response toResponse(Exception exception) {
        if(exception instanceof CustomException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponseBody(exception.getMessage()))
                    .build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponseBody("Something unexpected happened. Try again"))
                .build();
    }

    public static final class ErrorResponseBody {

        private final String message;

        public ErrorResponseBody(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}