package quarkusrest.controller;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import quarkusrest.dto.AwsResponse;
import quarkusrest.dto.UserResponse;
import quarkusrest.service.ServiceImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("/amazon-service")
@RequestScoped
public class ServiceController {

    @Inject
    private ServiceImpl service;
    @GET
    @Path("/check-user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AwsResponse checkUser(){
        AwsResponse userResponse= new AwsResponse(1,"Ali","30090","New York ,Broadway");
        return userResponse;
    }

    @GET
    @Path("/get-all/{users}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam String users){
        System.err.println("path-param2: "+users);
        List <UserResponse> setUsers=service.getAll();
        return Response.ok(setUsers).build();
    }
}
