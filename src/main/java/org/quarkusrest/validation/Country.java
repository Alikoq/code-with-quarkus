package org.quarkusrest.validation;

import org.jboss.logging.Logger;
import org.quarkusrest.controller.UserController;
import org.quarkusrest.dto.baseResponse.CommonErrorResponse;
import org.quarkusrest.dto.baseResponse.Messages;
import org.quarkusrest.exception.CountryException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class Country implements ValidationService{
    private static final Logger LOG= Logger.getLogger(UserController.class);

    @Inject
    CommonErrorResponse commonErrorResponse;

    @Override
    public boolean checkIt() throws CountryException {
        boolean result=false;
        LOG.info("Country check started");
        if(result){
            LOG.info("Country check it operations");
            return true;
        }
        commonErrorResponse.addMessage(new Messages("error","Country error check"));
        return false;
    }
}
