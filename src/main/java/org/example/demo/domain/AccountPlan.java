package org.example.demo.domain;

import org.example.demo.controller.AccountPlanServlet;

public class AccountPlan {
    private Long id;

    private String name;

    private String type;
    private int number;

    public AccountPlan(){}

    public AccountPlan(String name, String type, int number){
         this.name = name;
         this.type = type;
         this.number = number;
    }

    public AccountPlan(Long id,String name, String type, int number){
        this.id = id;
        this.name = name;
        this.type = type;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AccountPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                '}';
    }
}

