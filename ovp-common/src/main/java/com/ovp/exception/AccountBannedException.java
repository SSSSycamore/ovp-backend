package com.ovp.exception;

/**
 * 账号被封禁异常
 */
public class AccountBannedException extends RuntimeException {

    public AccountBannedException() {
    }

    public AccountBannedException(String msg) {
        super(msg);
    }
}
