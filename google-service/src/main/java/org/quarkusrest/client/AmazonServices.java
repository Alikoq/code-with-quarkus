package org.quarkusrest.client;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
@Path("amazon-service")
public interface AmazonServices {

    @GET
    @Path("/check-user")
    @Produces(MediaType.APPLICATION_JSON)
    AwsResponse checkUser();
}
