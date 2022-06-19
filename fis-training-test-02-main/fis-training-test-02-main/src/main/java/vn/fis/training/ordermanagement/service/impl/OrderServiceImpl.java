package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.*;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addOrderItem(Long id, OrderItem orderItem) {
        Order order = findById(id);
        order.getOrderItems().add(orderItem);
        order.setTotalAmount(order.getTotalAmount() + (orderItem.getAmount() * orderItem.getQuantity()));
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order removeOrderItem(Long id, OrderItem orderItem) {
        Order order = findById(id);
        order.setTotalAmount(order.getTotalAmount() - (orderItem.getAmount() * orderItem.getQuantity()));
        order.getOrderItems().remove(orderItem);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order updateOrderStatus(Order order, OrderStatus orderStatus) {
        order.setStatus(orderStatus);
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> findOrdersBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        List<Order> list = orderRepository.findByStartDateBetween(fromDateTime,toDateTime);
        return list;
    }

    @Override
    public List<Order> findWaitingApprovalOrders() {
        return orderRepository.findAll()
                .stream()
                .filter(t->t.getStatus().equals("WAITING_APPROVAL")).collect(Collectors.toList());
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findAll()
                .stream()
                .filter(t->t.getId().equals(orderStatus.equals(orderStatus))).collect(Collectors.toList());
    }

    @Override
    public List<Order> findOrdersByCustomer(Customer customer) {
        return orderRepository.findAll()
                .stream()
                .filter(t->t.getId().equals(customer.getId())).collect(Collectors.toList());
    }
}
