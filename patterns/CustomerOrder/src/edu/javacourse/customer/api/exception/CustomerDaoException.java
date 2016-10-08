package edu.javacourse.customer.api.exception;

public class CustomerDaoException extends Exception
{

    public CustomerDaoException() {
    }

    public CustomerDaoException(String message) {
        super(message);
    }

    public CustomerDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerDaoException(Throwable cause) {
        super(cause);
    }

    public CustomerDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
