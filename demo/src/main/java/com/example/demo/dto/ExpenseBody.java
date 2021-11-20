package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExpenseBody {
    Double expense;
    Long payee;
    int numberOfUsers;
    List<Long> users;
    ExpenseType expenseType;
    List<Double> expensePerUser;
}
