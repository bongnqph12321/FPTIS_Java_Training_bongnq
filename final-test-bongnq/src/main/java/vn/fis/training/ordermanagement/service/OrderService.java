package vn.fis.training.ordermanagement.service;


import vn.fis.training.ordermanagement.dto.CreateOrderDTO;
import vn.fis.training.ordermanagement.model.Order;


import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order create(CreateOrderDTO createOrderDTO);
    Order findById(Long id);

    List<Order> findAll(Order order);

    void deleteOrderById(Long orderId);

    Order updateOrder(Order order);

}
