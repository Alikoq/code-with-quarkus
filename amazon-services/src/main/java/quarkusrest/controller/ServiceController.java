package quarkusrest.controller;
import quarkusrest.dto.AwsResponse;
import quarkusrest.dto.UserResponse;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/amazon-service")
@RequestScoped
public class ServiceController {


    @GET
    @Path("/check-user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AwsResponse checkUser(){
        AwsResponse userResponse= new AwsResponse(1,"Ali","30090","New York ,Broadway");
        return userResponse;
    }
}
