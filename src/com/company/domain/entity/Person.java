package com.company.domain.entity;

public class Person {
    private int id;
    private String name;
    private String coefficient;

    public Person() {
    }


    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
