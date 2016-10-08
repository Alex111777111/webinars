package edu.javacourse.customer.api.exception;

public class CustomerOrderManagerException extends Exception
{

    public CustomerOrderManagerException() {
    }

    public CustomerOrderManagerException(String message) {
        super(message);
    }

    public CustomerOrderManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerOrderManagerException(Throwable cause) {
        super(cause);
    }

    public CustomerOrderManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
