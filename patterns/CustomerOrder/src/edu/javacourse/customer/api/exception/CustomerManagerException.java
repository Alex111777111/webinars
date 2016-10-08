package edu.javacourse.customer.api.exception;

public class CustomerManagerException extends Exception
{

    public CustomerManagerException() {
    }

    public CustomerManagerException(String message) {
        super(message);
    }

    public CustomerManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerManagerException(Throwable cause) {
        super(cause);
    }

    public CustomerManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
