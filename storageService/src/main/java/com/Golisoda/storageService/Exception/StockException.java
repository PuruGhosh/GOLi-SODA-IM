package com.Golisoda.storageService.Exception;


public class StockException extends RuntimeException {
    public StockException() {}

    /** @param message */
    public StockException(String message) {
        super(message);
    }

    /** @param cause */
    public StockException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public StockException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public StockException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
