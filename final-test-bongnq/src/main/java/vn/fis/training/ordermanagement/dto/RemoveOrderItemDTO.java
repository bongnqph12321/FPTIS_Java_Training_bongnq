package vn.fis.training.ordermanagement.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoveOrderItemDTO {
    private Long orderItemId;
    private Long orderId;

}