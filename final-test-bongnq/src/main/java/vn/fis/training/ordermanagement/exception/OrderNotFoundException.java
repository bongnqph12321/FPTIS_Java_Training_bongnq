package vn.fis.training.ordermanagement.exception;


public class OrderNotFoundException extends ApplicationException {
    public OrderNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return null;
    }
}
