package com.store;

class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) {
        super(message);
    }
}
