package org.quarkusrest.service;

 import org.quarkusrest.dto.UserRequest;
import org.quarkusrest.dto.UserResponse;
 import org.quarkusrest.dto.baseResponse.CommonResponse;
 import org.quarkusrest.entity.UserEntity;

public interface ApiServices {

    CommonResponse<UserResponse> addUser(UserRequest userRequest);
    CommonResponse<UserResponse> getUserById(Long id);
}
