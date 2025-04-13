package com.suyog.SpringBootRest.exceptions;

public class UnautherizedUserException extends RuntimeException {

    public UnautherizedUserException() {
        super("operation not authorized for this user");
    }

}
