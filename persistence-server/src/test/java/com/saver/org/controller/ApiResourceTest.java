package com.saver.org.controller;

import com.saver.org.entity.UserEntity;
import com.saver.org.repository.UserRepository;
import com.saver.org.service.UserServiceImpl;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ApiResourceTest {

    @InjectMock
    UserServiceImpl userService;

    @InjectMock
    UserRepository userRepository;

    @Inject
    ApiResource apiResource;

    UserEntity userEntity;

    @BeforeEach
    void setUp(){
        userEntity=new UserEntity();
        userEntity.setAddress("NewYork");
        userEntity.setName("Ali");
        userEntity.setAge((short)44);
        userEntity.setId(1L);

    }
    @Test
    void getAll() {
        List<UserEntity> userEntityList=new ArrayList<>();
        Mockito.when(userService.findAll()).thenReturn(userEntityList);
        userEntityList.add(userEntity);
        Response response= apiResource.getAll();//controller method
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());

        List<UserEntity> entities= (List<UserEntity>) response.getEntity();
        assertFalse(entities.isEmpty() );
        assertEquals("Ali",entities.get(0).getName());
        assertEquals(1,entities.get(0).getId());
        assertEquals((short) 44,entities.get(0).getAge());
    }



    @Test
    void getById() {
        Mockito.when(userService.getById(1L)).thenReturn(userEntity);
        Response response=apiResource.getById(1);
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());
        UserEntity userEntity=(UserEntity)response.getEntity();
        assertEquals("Ali",userEntity.getName());

    }
}