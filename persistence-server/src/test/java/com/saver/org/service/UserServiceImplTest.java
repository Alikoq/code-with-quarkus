package com.saver.org.service;

import com.saver.org.controller.ApiResource;
import com.saver.org.dto.UserResponse;
import com.saver.org.entity.UserEntity;
import com.saver.org.repository.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserServiceImplTest {
    @InjectMock
    UserRepository userRepository;

    @Inject
    UserServiceImpl userService;

    @Inject
    ApiResource resource;

    private UserEntity userEntity;

    @BeforeEach
    void init(){
        userEntity=new UserEntity();
        userEntity.setAddress("NewYork");
        userEntity.setName("Alik");
        userEntity.setAge((short)44);
        userEntity.setId(1L);
     }

    @Test
    void findAll() {
        List<UserEntity> userEntityList = new ArrayList<>();
        Mockito.when(userRepository.listAll()).thenReturn(userEntityList);
        userEntityList.add(userEntity);
        Response response= resource.getAll();//controller method
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());

        List<UserEntity> entities= (List<UserEntity>) response.getEntity();
        assertFalse(entities.isEmpty() );
        assertEquals("Alik",entities.get(0).getName());
        assertEquals(1,entities.get(0).getId());
    }

    @Test
    void saveUser() {
    }

    @Test
    void findById() {


    }


}