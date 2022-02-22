package com.saver.org.service;

import com.saver.org.entity.UserEntity;
import com.saver.org.repository.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class RepositoryTest {

    @Inject
    UserRepository userRepository;

    @BeforeEach
    void init(){

    }

    @Test
    void getById(){
       UserEntity userEntity= userRepository.findById(2L);
       assertNotNull(userEntity);
       assertEquals("Bakhar",userEntity.getName());

    }

    @Test
    void getByIdFalse(){
        UserEntity userEntity= userRepository.findById(1L);
        assertNotNull(userEntity);
        assertEquals("Ali",userEntity.getName());
    }
}
