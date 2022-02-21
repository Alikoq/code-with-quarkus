package com.saver.org.service;

import com.saver.org.dto.UserRequest;
import com.saver.org.entity.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface UserService {

    UserEntity saveUser(UserRequest userEntity);
    UserEntity findById(Long id);
    List<UserEntity> findAll();

}
