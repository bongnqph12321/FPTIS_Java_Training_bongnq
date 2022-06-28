package vn.fis.training.ordermanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_product")
@Getter
@Setter
public class Product {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=11, max=100)
    @Column(name="name")
    private String name;
    @NotNull
    @Min(value = 1,message = "giá phải lớn hơn 0 ")
    @Column(name="price")
    private Double price;
    @NotNull
    @Column(name = "available")
    private Long available;
}
