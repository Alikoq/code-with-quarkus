package org.quarkusrest.client;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.quarkusrest.dto.UserResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@RegisterRestClient
@Path("/amazon-service")
public interface AmazonServices {

    @GET
    @Path("/check-user")
    @Produces(MediaType.APPLICATION_JSON)
    AwsResponse checkUser();


    @GET
    @Path("/get-all/{users}")
    @Produces(MediaType.APPLICATION_JSON)
    List<UserResponse> getAllUsers(@PathParam String users);

}
