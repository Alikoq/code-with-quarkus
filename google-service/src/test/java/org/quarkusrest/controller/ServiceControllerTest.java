package org.quarkusrest.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.quarkusrest.dto.UserResponse;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;


@QuarkusTest
class ServiceControllerTest {


    @BeforeEach
    void init(){

    }
    @Test
    void checkUser() {
         given()
                .when()
                .accept(MediaType.APPLICATION_JSON)
                .pathParam("users","Ali")
                .get("/google-user-service/amazon-service/get-all-users/{users}")
                 .then()
                .body("id[1]",equalTo(7))
                .body("name[1]",equalTo("Bakhar"))
                .body("address[1]",equalTo("New York"))
                .body("age[1]",equalTo(39))
                .statusCode(Response.Status.OK.getStatusCode());
    }
}