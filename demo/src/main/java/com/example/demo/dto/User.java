package com.example.demo.dto;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    Long userId;

    String name;

    String email;

    @Min(value = 5000000000l, message = "Should be greater than 5000000000")
    @Max(value = 9999999999l, message = "Should be less than 9999999999")
    Long mobile;
}
