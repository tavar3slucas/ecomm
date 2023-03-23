package com.tavar3slucas.ecomm.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1l;

    public ObjectNotFoundException(String mgs){
        super(mgs);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg,cause);
    }
}
