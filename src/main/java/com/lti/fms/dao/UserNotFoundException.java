package com.lti.fms.dao;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String msg){
        super(msg);
    }

    public UserNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}
