package vn.fis.training.ordermanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.training.ordermanagement.dto.CreateOrderDTO;
import vn.fis.training.ordermanagement.dto.DetailOrderDTO;
import vn.fis.training.ordermanagement.model.Order;

import vn.fis.training.ordermanagement.model.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderItemService;
import vn.fis.training.ordermanagement.service.OrderService;

import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemService orderItemService;
    @GetMapping("{id}")
    public Order getById(@PathVariable Long id){
        return  this.orderService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<DetailOrderDTO> create(@RequestBody CreateOrderDTO createOrderDTO) {
        log.info("CreateOrderDTO: {}", createOrderDTO);
        Order savedOrder = orderService.create(createOrderDTO);
        DetailOrderDTO detailOrderDTO = DetailOrderDTO.Mapper.mapFromOrderEntity(savedOrder);
        log.info("Saved Detail Order: {}", detailOrderDTO);
        return new ResponseEntity<>(detailOrderDTO, HttpStatus.OK);
    }

    @GetMapping("/page")
    public Page<Order> listOrder(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
    ){
        return orderRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        5,
                        Sort.Direction.ASC,sortBy.orElse("id")
                )
        );
    }
    @PutMapping
    public Order updateOrder(@RequestBody Order order){
        return this.orderService.updateOrder(order);
    }
    @DeleteMapping("/delete/{orderId}")
    public void DeleteOrder(@PathVariable Long orderId){
        Order order=orderService.findById(orderId);
        if(order.getStatus().equals("CREATED")||order.getStatus().equals("CANCELLED ")){
            orderService.deleteOrderById(orderId);
        }
    }

    @PostMapping("/update/paid/{orderId}")
    public Order UpdateOrderStatus(@PathVariable Long orderId){
        Order order=orderRepository.findById(orderId).get();
        Order order1=new Order();
        if(order.getStatus().equals("CREATE")){
            order1.setId(orderId);
            order1.setOrderDateTime(order.getOrderDateTime());
            order1.setStatus(OrderStatus.PAID);
            order1.setTotalAmount(order.getTotalAmount());
            order1.setCustomer(order.getCustomer());
        }
        return orderService.createOrder(order1);
    }
    @PostMapping("/update/cancel/{orderId}")
    public Order UpdateOrderByStatus(@PathVariable Long orderId){
        Order order=orderRepository.findById(orderId).get();
        Order order1=new Order();
        if(order.getStatus().equals("CREATE")){
            order1.setId(orderId);
            order1.setOrderDateTime(order.getOrderDateTime());
            order1.setStatus(OrderStatus.CANCELLED);
            order1.setTotalAmount(order.getTotalAmount());
            order1.setCustomer(order.getCustomer());
        }
        return orderService.createOrder(order1);
    }

}

/*
* GET http://localhost:8899/api/order/{pageNumber}/pageSize
* GET http://localhost:8899/api/order?pageNumber=0&pageSiz=10
* Tat ca succ: 200
* Exception : 500 : Internal Server Error
* Http.NotFound --> Customer Not Found
* */

