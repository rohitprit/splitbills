package com.example.demo.controller;

import com.example.demo.dto.ExpenseBody;
import com.example.demo.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin@RequestMapping("/expense/v1")
@RestController
@Slf4j
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/ping")
    public ResponseEntity<Object> expenseServiceStatus(){
        return ResponseEntity.ok().body("Running");
    }

    @GetMapping("/show")
    public ResponseEntity<Object> getAllBalances(){
        return expenseService.getAllBalances();
    }

    @GetMapping("/show/{userID}")
    public ResponseEntity<Object> getBalanceByUserId(@PathVariable Long userID){
        return expenseService.getBalanceByUserId(userID);
    }

    @PostMapping("/addExpense")
    public ResponseEntity<Object> addExpense(@RequestBody @Valid ExpenseBody expenseBody){

        return expenseService.addExpense(expenseBody);
    }

}
