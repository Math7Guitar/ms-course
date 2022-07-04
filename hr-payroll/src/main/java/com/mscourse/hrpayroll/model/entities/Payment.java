package com.mscourse.hrpayroll.model.entities;

import java.io.Serializable;

public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private Double dailyIncome;
    private Integer days;
    

    //Constructors
    public Payment(String name, Double dailyIncome, Integer days) {
        super();
        setName(name);
        setDailyIncome(dailyIncome);
        setDays(days);
    }

    public Payment() {}

    //Getters
    public String getName() { return this.name; }  
    public Double getDailyIncome() { return dailyIncome; }
    public Integer getDays() { return days; }


    //Setters
    private void setName(String name) { this.name = name; }
    private void setDailyIncome(Double dailyIncome) { this.dailyIncome = dailyIncome; }
    private void setDays(Integer days) { this.days = days; }

    //Utils
    public double getTotal() {
        return this.days * this.dailyIncome;
    }
}
