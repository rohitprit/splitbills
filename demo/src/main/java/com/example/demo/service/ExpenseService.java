package com.example.demo.service;

import com.example.demo.dto.DbClass;
import com.example.demo.dto.ExpenseBody;
import com.example.demo.manager.ExpenseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    ExpenseManager expenseManager;

    public ResponseEntity<Object> getAllBalances(){

        return ResponseEntity.ok().body(DbClass.getInstance().getExpenseMap());
    }

    public ResponseEntity<Object> getBalanceByUserId(Long userID){
        return ResponseEntity.ok().body(DbClass.getInstance().getExpenseMap().get(userID));
    }

    public ResponseEntity<Object> addExpense(ExpenseBody expenseBody){
        expenseManager.addExpense(expenseBody);
        return ResponseEntity.ok().body("Ok");
    }
}
