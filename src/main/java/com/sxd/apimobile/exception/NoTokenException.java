package com.sxd.apimobile.exception;

/**
 * 无Token异常
 */
public class NoTokenException extends CheckedException {
    public NoTokenException() {
        super();
    }

    public NoTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoTokenException(String message) {
        super(message);
    }

    public NoTokenException(Throwable cause) {
        super(cause);
    }
}
