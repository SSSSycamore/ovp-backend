package com.ovp.exception;

public class AccountExistException extends RuntimeException {
    public AccountExistException() {
    }
    public AccountExistException(String msg) {
        super(msg);
    }
}
