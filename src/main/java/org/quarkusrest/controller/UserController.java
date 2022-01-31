package org.quarkusrest.controller;


import org.h2.engine.User;
import org.quarkusrest.dto.UserRequest;
import org.quarkusrest.dto.UserResponse;
import org.quarkusrest.dto.baseResponse.CommonResponse;
import org.quarkusrest.service.ApiServices;
import org.quarkusrest.service.ApiServicesImpl;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/v1/api")
@RequestScoped
public class UserController {

    private final ApiServicesImpl apiServices;

    @Inject
    public UserController(ApiServicesImpl apiServices){
        this.apiServices=apiServices;
    }

    @GET
    @Path("/user-by-id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(@PathParam("id") Long id) {
        CommonResponse<UserResponse> commonResponse=apiServices.getUserById(id);
      return Response.ok(commonResponse).build();
    }

    @POST
    @Path("/add-user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response  addUser( UserRequest userRequest){
        CommonResponse<UserResponse> userResponse= apiServices.addUser(userRequest);
        return Response.ok(userResponse).build();
    }


}
