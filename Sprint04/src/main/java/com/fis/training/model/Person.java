package com.fis.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "person")
public class Person extends AbstractEntity{
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    private LocalDateTime hiringDate;
}
