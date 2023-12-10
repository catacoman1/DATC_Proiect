package com.citydangeralert.demo.Entities;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Container(containerName = "Users")
public class UserEntity {
    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String role;


}