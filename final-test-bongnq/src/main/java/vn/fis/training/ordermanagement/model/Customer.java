package vn.fis.training.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="tbl_customer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull
    private Long id;

    @NotNull
    @Min(value = 11,message = "name phải từ 11 kí tự trở lên")
    @Max(value = 100,message = "name không được trên 100 kí tự")
    @Column(name="name", length = 100)
    private String name;

    @NotNull
    @Column(name="mobile", length = 10)
    private String mobile;

    @NotNull
    @Column(name="address", length = 200)
    private String address;

}
