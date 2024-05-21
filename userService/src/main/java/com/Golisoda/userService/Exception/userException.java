package com.Golisoda.userService.Exception;


public class userException extends RuntimeException {
    public userException() {}

    /** @param message */
    public userException(String message) {
        super(message);
    }

    /** @param cause */
    public userException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public userException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public userException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
