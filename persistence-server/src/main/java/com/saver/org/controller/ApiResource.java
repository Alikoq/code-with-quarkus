package com.saver.org.controller;

import com.saver.org.dto.UserRequest;
import com.saver.org.entity.UserEntity;
import com.saver.org.service.UserServiceImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/user-data")
@RequestScoped
public class ApiResource {
    private UserServiceImpl userService;
    @Inject
    ApiResource(UserServiceImpl userService){
        this.userService=userService;
    }

    @GET
    @Path("/get-all-users")
    public Response getAll(){
        List<UserEntity> list= userService.findAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/get-by-id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(Long id){
        UserEntity userEntity=userService.getById(id);
        return Response.ok(userEntity).build();
    }

    @POST
    @Path("/add-user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(UserRequest userRequest){
        UserEntity userEntity=userService.saveUser(userRequest);
        return Response.ok(userEntity.getId()).build();
    }

}
