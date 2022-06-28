package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.dto.CreateOrderItemDTO;
import vn.fis.training.ordermanagement.dto.OrderDTO;
import vn.fis.training.ordermanagement.dto.RemoveOrderItemDTO;
import vn.fis.training.ordermanagement.exception.InvalidOrderException;
import vn.fis.training.ordermanagement.exception.OrderItemNotFoundException;
import vn.fis.training.ordermanagement.exception.OrderNotFoundException;
import vn.fis.training.ordermanagement.model.Order;
import vn.fis.training.ordermanagement.model.OrderItem;
import vn.fis.training.ordermanagement.model.OrderStatus;
import vn.fis.training.ordermanagement.model.Product;
import vn.fis.training.ordermanagement.repository.OrderItemRepository;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.repository.ProductRepository;
import vn.fis.training.ordermanagement.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemRepository  orderItemRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;



    private OrderItem createNewOrderItem(Order order, CreateOrderItemDTO createOrderItemDTO)
    {
        Product product = productRepository.findById(createOrderItemDTO.getProductId())
                .orElseThrow(() -> new InvalidOrderException(order,"Not found product id =" + createOrderItemDTO.getProductId()));
        Long newAvailable = product.getAvailable()-createOrderItemDTO.getQuantity();
        if(newAvailable<0) throw new InvalidOrderException(order,"Product not Available");
        product.setAvailable(newAvailable);
        return OrderItem.builder()
                .order(order)
                .product(product)
                .amount(product.getPrice()*createOrderItemDTO.getQuantity())
                .build();


    }

    @Override
    public OrderDTO addOrderItem(CreateOrderItemDTO createOrderItemDTO) {
        Order order = orderRepository.findById(createOrderItemDTO.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
        if(!order.getStatus().equals(OrderStatus.CREATED))
            throw new InvalidOrderException(order,"Order status must Created");
        order.getOrderItems().add(createNewOrderItem(order, createOrderItemDTO));
        order.setTotalAmount(order.getOrderItems().stream().mapToDouble(item ->item.getAmount()).sum());
        return OrderDTO.Mapper.fromEntity(orderRepository.save(order));
    }

    @Override
    public OrderDTO removeOrderItem(RemoveOrderItemDTO removeOrderItemDTO) {
        Order order = orderRepository.findById(removeOrderItemDTO.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
        if(!order.getStatus().equals(OrderStatus.CREATED))
            throw new InvalidOrderException(order,"Order status must Created");
        OrderItem orderItem = orderItemRepository.findById(removeOrderItemDTO.getOrderItemId())
                .orElseThrow(() -> new OrderItemNotFoundException("Order item not found"));
        order.getOrderItems().remove(orderItem);
        order.setTotalAmount(order.getOrderItems().stream().mapToDouble(item ->item.getAmount()).sum());
        return OrderDTO.Mapper.fromEntity(orderRepository.save(order));
    }


}
