package com.citydangeralert.demo.Entities;

import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String role;


}