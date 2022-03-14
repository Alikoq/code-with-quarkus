package org.quarkusrest.service;


import org.jboss.logging.Logger;
import org.quarkusrest.config.ValidationConfig;
import org.quarkusrest.dto.UserResponse;
import org.quarkusrest.dto.baseResponse.CommonErrorResponse;
import org.quarkusrest.dto.baseResponse.Messages;
import org.quarkusrest.exception.CountryException;
import org.quarkusrest.exception.UserException;
import org.quarkusrest.validation.Country;
import org.quarkusrest.validation.User;
import org.quarkusrest.validation.ValidationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ValidationImpl {
    public static final Logger LOG=Logger.getLogger(ValidationImpl.class);

    @Inject
    CommonErrorResponse commonErrorResponse;
    @Inject
    Country country;
    @Inject
    User user;

    public UserResponse tetValidation()  {
        List<ValidationService> list=new ArrayList<>();
        list.add(country);
        list.add(user);
        try {
             for(ValidationService v: list){
                boolean res= v.checkIt();
             }
            if(commonErrorResponse.getMessages().size()>0){
                 throw new UserException(commonErrorResponse.getMessages());
            }

        }catch (RuntimeException ex){
             throw new UserException(commonErrorResponse.getMessages());
        }
        return new UserResponse("Ali","New York");
    }


}
