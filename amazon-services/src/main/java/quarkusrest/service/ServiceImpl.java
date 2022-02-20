package quarkusrest.service;

import quarkusrest.dto.UserResponse;

import javax.inject.Singleton;
import java.util.*;

@Singleton
public class ServiceImpl {
    List<UserResponse> setUsers=new ArrayList<>();

     public ServiceImpl(){
            add();
     }

     public void add(){
         setUsers.add(new UserResponse(2L,"Ali","New York",38));
         setUsers.add(new UserResponse(7L,"Bakhar","New York",39));
         setUsers.add(new UserResponse(9L,"Eduard","New York",6));
     }
     public List<UserResponse> getAll(){
         return setUsers;
     }
}
