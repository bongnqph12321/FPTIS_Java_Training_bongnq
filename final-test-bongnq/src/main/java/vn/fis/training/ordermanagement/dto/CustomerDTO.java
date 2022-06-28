package vn.fis.training.ordermanagement.dto;

import lombok.*;
import vn.fis.training.ordermanagement.model.Customer;
import vn.fis.training.ordermanagement.model.Order;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private Long id;
    private String name;
    private String mobile;
    private String address;
    List<Order> orders;

    public static class Mapper {
        public static CustomerDTO mapFromCustomerEntity(Customer customer) {
            return CustomerDTO.builder()
                    .id(customer.getId())
                    .name(customer.getName())
                    .mobile(customer.getMobile())
                    .address(customer.getAddress())
                    .build();
        }
    }
}
