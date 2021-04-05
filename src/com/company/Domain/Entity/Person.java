package com.company.Domain.Entity;

public class Person {
    private int id;
    private String name;
    private String coefficient;

    public Person() {

    }

    public String toString() {
        return id + "," + name + "," + coefficient;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coeficient) {
        this.coefficient = coeficient;
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
