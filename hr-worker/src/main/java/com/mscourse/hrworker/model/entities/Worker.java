package com.mscourse.hrworker.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
@Table(name="tb_workers")
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DAILYINCOME")
    private Double dailyIncome;

    //Construtors
    @PersistenceConstructor
    public Worker(Long id, String name, Double dailyIncome) {
        this.setId(id);
        this.setName(name);
        this.setDailyIncome(dailyIncome);
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
