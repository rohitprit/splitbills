package com.example.demo.dto;

import java.util.Map;

public class DbClass {
    private Map<Long, Map<Long,Double>> expenseByUser;

    private static class SingletonClass {
        private static final DbClass INSTANCE = new DbClass();
    }

    public static DbClass getInstance() {
        return SingletonClass.INSTANCE;
    }

    public Map getExpenseMap(){
        return expenseByUser;
    }

    public void setExpenseMap(Map<Long, Map<Long,Double>> expenseByUser){
         this.expenseByUser=expenseByUser;
    }
}
