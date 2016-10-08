package edu.javacourse.customer.api.exception;

public class CustomerOrderDaoException extends Exception
{

    public CustomerOrderDaoException() {
    }

    public CustomerOrderDaoException(String message) {
        super(message);
    }

    public CustomerOrderDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerOrderDaoException(Throwable cause) {
        super(cause);
    }

    public CustomerOrderDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
