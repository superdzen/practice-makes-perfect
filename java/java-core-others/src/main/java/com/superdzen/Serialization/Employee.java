package com.superdzen.Serialization;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by superdzen@gmail.com on 13.11.2017.
 */
public class Employee implements Serializable {
    private int id;
    private String name;
    private BigDecimal salary;

    public Employee(int id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
