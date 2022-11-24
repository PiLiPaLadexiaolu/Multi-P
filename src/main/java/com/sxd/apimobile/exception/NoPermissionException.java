package com.sxd.apimobile.exception;

/**
 * 无权限异常
 */
public class NoPermissionException extends CheckedException {
    public NoPermissionException() {
        super();
    }

    public NoPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPermissionException(String message) {
        super(message);
    }

    public NoPermissionException(Throwable cause) {
        super(cause);
    }
}
