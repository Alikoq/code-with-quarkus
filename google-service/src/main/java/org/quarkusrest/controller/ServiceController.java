package org.quarkusrest.controller;


import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.quarkusrest.client.AmazonServices;
import org.quarkusrest.client.AwsResponse;
import org.quarkusrest.dto.UserRequest;
import org.quarkusrest.dto.UserResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

}
