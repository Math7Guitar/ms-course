package com.mscourse.hrpayroll.model.classes;

public class Worker {

    private Long id;

    private String name;

    private Double dailyIncome;

    //Construtors
    public Worker(Long id, String name, Double dailyIncome) {
        setId(id);
        setName(name);
        setDailyIncome(dailyIncome);
    }

    public Worker() {}



    //Getters
    public long getId() { return this.id; }
    public String getName() { return this.name; }
    public Double getDailyIncome() { return this.dailyIncome; }


    //Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDailyIncome(Double di) { this.dailyIncome = di; }  
}
