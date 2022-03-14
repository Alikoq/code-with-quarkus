package org.quarkusrest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.quarkusrest.entity.UserEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    private Long id;
    private String name;
    private String address;
    private Short age;

    public UserResponse() {
    }

    public UserResponse(String name, String address){
        this.name=name;
        this.address=address;
    }
    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.address = userEntity.getAddress();
        this.age = userEntity.getAge();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }
}
