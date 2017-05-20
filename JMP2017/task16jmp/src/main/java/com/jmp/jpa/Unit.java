package com.jmp.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gleb88 on 20.05.2017.
 */
@Entity
public class Unit {
    @Column(name = "NAME")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "unit", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Unit() {
    }

    public Unit(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
