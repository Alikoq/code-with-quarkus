package org.quarkusrest.entity;

import org.quarkusrest.dto.UserRequest;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Short age;

    public UserEntity() {
    }

    public UserEntity(UserRequest userRequest){
        this.name=userRequest.getName();
        this.address=userRequest.getAddress();
        this.age=userRequest.getAge();
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
