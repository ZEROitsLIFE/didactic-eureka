package com.doc.exception;

public class ModelNotFoundExeption extends RuntimeException{

    public ModelNotFoundExeption(String message) {
        super(message);
    }

    public ModelNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }


}
