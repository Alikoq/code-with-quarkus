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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserServiceImplTest {
    @Inject
    UserRepository userRepository;

    @Inject
    private ApiResource resource;

    private UserEntity userEntity;

    @BeforeEach
    void init(){
        userEntity=new UserEntity();
        userEntity.setAddress("NewYork");
        userEntity.setName("Ali");
        userEntity.setAge((short)44);
        userEntity.setId(1L);
     }

    @Test
    void findAll() {
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(userEntity);
        Mockito.when(userRepository.listAll()).thenReturn(userEntityList);
        Response response= resource.getAll();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());

        List<UserEntity> entities= (List<UserEntity>) response.getEntity();
        assertFalse(entities.isEmpty() );
        assertEquals("Ali",entities.get(0).getName());
    }

    @Test
    void saveUser() {
    }

    @Test
    void findById() {

    }


}