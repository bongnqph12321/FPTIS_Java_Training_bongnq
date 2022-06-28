package vn.fis.training.ordermanagement.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.dto.CreateOrderDTO;
import vn.fis.training.ordermanagement.model.*;
import vn.fis.training.ordermanagement.repository.OrderItemRepository;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.CustomerService;
import vn.fis.training.ordermanagement.service.OrderService;
import vn.fis.training.ordermanagement.service.ProductService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    ProductService  productService;


    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order create(CreateOrderDTO createOrderDTO) {
        Customer customer = customerService.findById(createOrderDTO.getCustomerId());
        List<OrderItem> orderItemList = new ArrayList<>();
        createOrderDTO.getOrderItemInfo().forEach(productQuantityDTO -> {
            Product product = productService.findById(productQuantityDTO.getProductId());
            OrderItem orderItem = OrderItem.builder()
                    .product(product)
                    .quantity(productQuantityDTO.getQuantity())
                    .amount(product.getPrice() * productQuantityDTO.getQuantity())
                    .build();
            orderItemList.add(orderItem);
        });
        Order order = Order.builder()
                .orderDateTime(LocalDateTime.now())
                .status(OrderStatus.CREATED)
                .customer(customer)
                .orderItems(orderItemList)
                .totalAmount(orderItemList.stream().mapToDouble(OrderItem::getAmount).sum())
                .build();
        orderRepository.save(order);
        return order;
    }


    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findAll(Order order) {
        return null;
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
}
