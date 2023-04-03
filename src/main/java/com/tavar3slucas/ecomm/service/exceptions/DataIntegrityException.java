package com.tavar3slucas.ecomm.service.exceptions;

public class DataIntegrityException extends RuntimeException{

    private static final long serialVersionUID = 1l;

    public DataIntegrityException(String mgs){
        super(mgs);
    }

    public DataIntegrityException(String msg, Throwable cause){
        super(msg,cause);
    }
}
