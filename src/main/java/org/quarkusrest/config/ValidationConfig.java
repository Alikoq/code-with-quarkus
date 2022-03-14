package org.quarkusrest.config;

import io.quarkus.arc.DefaultBean;
import io.quarkus.logging.Log;
import org.jboss.logging.Logger;
import org.quarkusrest.dto.baseResponse.CommonErrorResponse;
import org.quarkusrest.service.ValidationImpl;
import org.quarkusrest.validation.Country;
import org.quarkusrest.validation.User;
import org.quarkusrest.validation.ValidationService;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Calendar;

@Dependent
public class ValidationConfig {
    public  static final Logger LOG= Logger.getLogger(ValidationConfig.class);
    @DefaultBean
    @Named("countryValidation")
    public ValidationService countryValidation(){
        LOG.info("Country validation bean initialized");
        return new Country();
    }


    @DefaultBean
    @Named("userValidation")
    public ValidationService userValidation(){
        LOG.info("User validation bean initialized");
        return new User();
    }

    @Singleton
    @Named("errorMessage")
    public CommonErrorResponse commonErrorResponse(){
        LOG.info("common error response bean initialized");

        return new CommonErrorResponse();
    }

}
