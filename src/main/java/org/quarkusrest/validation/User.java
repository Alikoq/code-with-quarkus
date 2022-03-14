package org.quarkusrest.validation;

import org.jboss.logging.Logger;
import org.quarkusrest.controller.UserController;
import org.quarkusrest.dto.baseResponse.CommonErrorResponse;
import org.quarkusrest.dto.baseResponse.Messages;
import org.quarkusrest.exception.CountryException;
import org.quarkusrest.exception.UserException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class User implements ValidationService {
    private static final Logger LOG= Logger.getLogger(UserController.class);

    @Inject
    CommonErrorResponse commonErrorResponse;

    @Override
    public boolean checkIt()  {
        boolean result=false;
        LOG.info("user check it started");
        if(result) {
            LOG.info("User operations");
            return true;
        }
        commonErrorResponse.addMessage(new Messages("error","User error check"));
        return false;

    }
}
