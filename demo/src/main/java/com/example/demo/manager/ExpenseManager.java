package com.example.demo.manager;

import com.example.demo.dto.DbClass;
import com.example.demo.dto.ExpenseBody;
import com.example.demo.dto.ExpenseType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class ExpenseManager {

    public void addExpense(ExpenseBody expenseBody){
        try{
            Map<Long, Map<Long,Double>> expenseMap= DbClass.getInstance().getExpenseMap();
            Map<Long,Double> payeeMap = expenseMap.get(expenseBody.getPayee());
            if(expenseBody.getExpenseType()== ExpenseType.EQUAL){
                //For adding remaining to first user
                double remainingAmount=0;
                if(!(expenseBody.getNumberOfUsers() * (expenseBody.getExpense()/expenseBody.getNumberOfUsers())==expenseBody.getExpense())){
                    remainingAmount = expenseBody.getExpense()-(expenseBody.getNumberOfUsers() * (expenseBody.getExpense()/expenseBody.getNumberOfUsers()));
                }

            }
            if(expenseBody.getExpenseType()== ExpenseType.EXACT){

            }
            if(expenseBody.getExpenseType()== ExpenseType.PERCENT){

            }

            DbClass.getInstance().setExpenseMap(expenseMap);
        }
        catch (Exception e){
            log.error("error in adding expense");
        }
    }


}
