package org.quarkusrest.controller;


import org.jboss.logging.Logger;
import org.quarkusrest.dto.UserRequest;
import org.quarkusrest.dto.UserResponse;
import org.quarkusrest.dto.baseResponse.CommonErrorResponse;
import org.quarkusrest.dto.baseResponse.CommonResponse;
import org.quarkusrest.exception.CountryException;
import org.quarkusrest.service.ApiServicesImpl;
import org.quarkusrest.service.ValidationImpl;
import org.quarkusrest.validation.Country;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/api")
@RequestScoped
public class UserController {

    private final ApiServicesImpl apiServices;
    private final ValidationImpl validationService;
    private static final Logger LOG= Logger.getLogger(UserController.class);

    public UserController(ApiServicesImpl apiServices,ValidationImpl validationService){
        this.apiServices=apiServices;
        this.validationService=validationService;
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


    @GET
    @Path("/validate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validate() throws CountryException {
        UserResponse userResponse=validationService.tetValidation();

       return Response.ok(userResponse).build();

    }

}
