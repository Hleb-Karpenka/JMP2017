package com.jmp.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gleb88 on 20.05.2017.
 */

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "employee")
    private Set<Employee> emplyeesOnProject = new HashSet<>();


    public Project() {
    }

    public Project(long id, String name, Set<Employee> emplyeesOnProject) {
        this.id = id;
        this.name = name;
        this.emplyeesOnProject = emplyeesOnProject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmplyeesOnProject() {
        return emplyeesOnProject;
    }

    public void setEmplyeesOnProject(Set<Employee> emplyeesOnProject) {
        this.emplyeesOnProject = emplyeesOnProject;
    }
}
