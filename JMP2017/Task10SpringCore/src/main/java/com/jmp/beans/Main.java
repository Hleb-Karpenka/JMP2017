package com.jmp.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Gleb88 on 26.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml" );
        ClassA classA = (ClassA) context.getBean("A");
        ClassB classB = (ClassB) context.getBean("B");
        ClassD classD = (ClassD) context.getBean("D");
        classD.setField6("old ");
        ClassC classC = (ClassC) context.getBean("C");
        ClassE classE = (ClassE) context.getBean("E");
        ClassF classF = (ClassF) context.getBean("F");


        System.out.println(classA);
        System.out.println(classB);
        System.out.println(classC);
        System.out.println(classD);
        classE.method1();
        System.out.println(classF);
    }
}
