package br.com.fiapfood.order.application.exception;

import jakarta.persistence.EntityNotFoundException;

public class ObjectNotFoundException extends EntityNotFoundException {
    public ObjectNotFoundException(String message){
        super(message);
    }
}
