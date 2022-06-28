package vn.fis.training.ordermanagement.exception;


import vn.fis.training.ordermanagement.model.Order;

public class InvalidOrderException extends ApplicationException {

    private Order order;

    public InvalidOrderException(Order order, String message) {
        super(message);
        this.order = order;
    }



    public Order getOrder() {
        return this.order;
    }

    @Override
    public String getErrorCode() {
        return null;
    }
}