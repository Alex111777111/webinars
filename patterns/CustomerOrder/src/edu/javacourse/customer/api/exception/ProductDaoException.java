package edu.javacourse.customer.api.exception;

public class ProductDaoException extends Exception
{

    public ProductDaoException() {
    }

    public ProductDaoException(String message) {
        super(message);
    }

    public ProductDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDaoException(Throwable cause) {
        super(cause);
    }

    public ProductDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
