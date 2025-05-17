package com.ovp.exception;

/**
 * 账户不存在异常
 */
public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
