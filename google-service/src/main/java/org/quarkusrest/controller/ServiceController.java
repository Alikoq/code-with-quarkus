package org.quarkusrest.controller;


import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.quarkusrest.client.AmazonServices;
import org.quarkusrest.client.AwsResponse;
import org.quarkusrest.dto.UserRequest;
import org.quarkusrest.dto.UserResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("/google-user-service")
@RequestScoped
public class ServiceController {


    @RestClient
    @Inject
    AmazonServices amazonServices;


    @GET
    @Path("/amazon-service/check-user")
    @Produces(MediaType.APPLICATION_JSON)
    public AwsResponse checkUser(){
      AwsResponse res=  amazonServices.checkUser();
      return res;
    }

    @GET
    @Path("/amazon-service/get-all-users/{users}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(@PathParam String users){
        System.out.println("google param: "+users);
        List<UserResponse> res=  amazonServices.getAllUsers(users);

        return Response.ok(res).build();
    }

}
