package com.suyog.SpringBootRest.exceptions;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException() {
        super("No Data Found.");
    }

}
