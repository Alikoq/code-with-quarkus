package org.quarkusrest.validation;

import org.quarkusrest.exception.CountryException;

import javax.enterprise.context.ApplicationScoped;

 public interface ValidationService {
    boolean checkIt();
}
