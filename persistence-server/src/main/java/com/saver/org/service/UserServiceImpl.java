package com.saver.org.service;


import com.saver.org.dto.UserRequest;
import com.saver.org.entity.UserEntity;
import com.saver.org.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.naming.NoPermissionException;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService{

    @Inject
    private UserRepository userRepository;

    @Override
    public UserEntity saveUser(UserRequest userRequest) {
        UserEntity userEntity=new UserEntity(userRequest);
        userRepository.persist(userEntity);
        if(!userRepository.isPersistent(userEntity)){
            throw new NotFoundException("User not saved");
        }
        return userEntity;
    }

    @Override
    public UserEntity findById(Long id) {
      UserEntity entity=  userRepository.findById(id);
      if(entity!=null){
          return entity;
      }
      throw new NotFoundException(String.format("User %d not found",id));
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> getAll=userRepository.listAll();
        if(getAll.isEmpty())
            throw new NotFoundException("Table is empty");
        return getAll;
    }

}
