package com.telephonestation.reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("clients")
public class Client {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}