package vn.fis.training.ordermanagement.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.fis.training.ordermanagement.dto.CreateOrderItemDTO;
import vn.fis.training.ordermanagement.dto.OrderDTO;
import vn.fis.training.ordermanagement.dto.RemoveOrderItemDTO;
import vn.fis.training.ordermanagement.service.OrderItemService;

@RestController
@RequestMapping("/api/orderItem")
@CrossOrigin("*")
@Slf4j
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @PostMapping("/addOrderItem")
    public OrderDTO addOrderItem(@RequestBody CreateOrderItemDTO createOrderItemDTO)
    {
        log.info("Add new order item of order id :{}",createOrderItemDTO.getOrderId());
        return orderItemService.addOrderItem(createOrderItemDTO);
    }

    @PostMapping("/removeOrderItem")
    public OrderDTO removeOrderItem(@RequestBody RemoveOrderItemDTO removeOrderItemDTO)
    {
        log.info("remove order item id: {} of order id :{}",removeOrderItemDTO,removeOrderItemDTO.getOrderId());
        return orderItemService.removeOrderItem(removeOrderItemDTO);
    }
}
