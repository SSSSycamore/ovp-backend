package com.ovp.exception;

public class FileUploadFailedException extends RuntimeException {
    public FileUploadFailedException() {
    }

    public FileUploadFailedException(String msg) {
        super(msg);
    }
}
