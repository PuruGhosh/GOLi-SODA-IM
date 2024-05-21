package com.Golisoda.storageService.Exception;


public class BatchException extends RuntimeException {
    public BatchException() {}

    /** @param message */
    public BatchException(String message) {
        super(message);
    }

    /** @param cause */
    public BatchException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public BatchException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public BatchException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
