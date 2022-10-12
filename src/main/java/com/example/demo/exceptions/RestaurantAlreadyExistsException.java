package com.example.demo.exceptions;

public class RestaurantAlreadyExistsException extends RuntimeException {
    public RestaurantAlreadyExistsException(Long id) {
        super(String.format("Restaurant already exists with id: %d", id));
    }
}
