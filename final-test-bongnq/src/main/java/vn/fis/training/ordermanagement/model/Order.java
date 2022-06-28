package vn.fis.training.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="tbl_order")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull
    private Long id;

    @NotNull
    @Column(name="order_datetime")
    private LocalDateTime orderDateTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

//    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @NotNull
    @Column(name="total_amount")
    private Double totalAmount;

    @NotNull
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
