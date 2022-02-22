package com.saver.org.repository;


import com.saver.org.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

    public UserEntity getById(Long id){
        return find("SELECT m FROM UserEntity",id).firstResult();
    }
}
