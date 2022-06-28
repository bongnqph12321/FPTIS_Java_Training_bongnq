package vn.fis.training.ordermanagement.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderItemDTO {
    private Long orderId;
    private Long productId;
    private Integer quantity;

}