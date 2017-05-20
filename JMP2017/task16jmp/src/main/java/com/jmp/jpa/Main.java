package com.jmp.jpa;

import java.util.HashSet;

/**
 * Created by Gleb88 on 20.05.2017.
 */
public class Main {

    public static void main(String[] args) {

        Address address = new Address("1st aveue", 10,3);
        PersonalInfo info = new PersonalInfo();
        Project pr1 = new Project();
        Project pr2 = new Project();
        HashSet setOfProject = new HashSet();
        setOfProject.add(pr1);
        setOfProject.add(pr2);
        Unit unit = new Unit();
        Employee employee = new Employee("Link","Hyrils", EmployeeStatus.WORKER,address, info,setOfProject, unit );
    }
}
