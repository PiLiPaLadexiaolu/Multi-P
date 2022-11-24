package com.sxd.apimobile.exception;

/**
 * 基础异常类
 */
public class CheckedException extends RuntimeException {
    public CheckedException() {
        super();
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(Throwable cause) {
        super(cause);
    }
}
