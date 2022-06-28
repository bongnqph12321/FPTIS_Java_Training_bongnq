package vn.fis.training.ordermanagement.exception;

import javax.management.InvalidApplicationException;

public abstract class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }

    public abstract String getErrorCode();
}