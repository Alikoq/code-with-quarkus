package org.quarkusrest.service;

 import org.quarkusrest.dto.UserRequest;
import org.quarkusrest.dto.UserResponse;
 import org.quarkusrest.dto.baseResponse.CommonResponse;
 import org.quarkusrest.dto.baseResponse.Messages;
 import org.quarkusrest.entity.UserEntity;
 import org.quarkusrest.exception.CustomException;
 import org.quarkusrest.exception.UserException;
 import org.quarkusrest.repository.UserRepository;

 import javax.enterprise.context.ApplicationScoped;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Optional;

@ApplicationScoped
public class ApiServicesImpl implements ApiServices {
    private final UserRepository userRepository;

    public ApiServicesImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }



    @Override
    public CommonResponse<UserResponse> addUser(UserRequest userRequest) {

        UserEntity entity=userRepository.save(new UserEntity(userRequest));
        UserResponse createdUser=new UserResponse(entity);
        return fillCommonResponse(createdUser,fillMessage("User created","success"),200);

    }

    @Override
    public CommonResponse<UserResponse> getUserById(Long id) {
        Optional<UserEntity> userEntity=userRepository.findById(id);
        if(userEntity.isPresent()){
            UserResponse userResponse=new UserResponse(userEntity.get());
            return fillCommonResponse(userResponse,fillMessage(String.format("User with ID: %d",id),"success"),200);
        }
        throw new CustomException(String.format("User with ID: %d not found",id),404);
    }

    public <T>CommonResponse<T> fillCommonResponse(T object, List<Messages> messages, Integer status){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        commonResponse.setMessages(messages);
        commonResponse.setStatus(status);
        commonResponse.setData(object);
        return commonResponse;
    }

    public List<Messages> fillMessage(String message, String type){
        Messages messages=new Messages(type,message);
        List<Messages> messagesList=new ArrayList<>();
        messagesList.add(messages);
        return messagesList;
    }
}
