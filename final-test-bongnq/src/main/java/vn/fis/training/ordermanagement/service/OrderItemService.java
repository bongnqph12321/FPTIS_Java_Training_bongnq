package vn.fis.training.ordermanagement.service;

import vn.fis.training.ordermanagement.dto.CreateOrderItemDTO;
import vn.fis.training.ordermanagement.dto.OrderDTO;
import vn.fis.training.ordermanagement.dto.RemoveOrderItemDTO;


public interface OrderItemService {
    OrderDTO addOrderItem(CreateOrderItemDTO createOrderItemDTO);

    OrderDTO removeOrderItem(RemoveOrderItemDTO removeOrderItemDTO);
}
