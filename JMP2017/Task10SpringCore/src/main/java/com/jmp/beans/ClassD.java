package com.jmp.beans;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by Gleb88 on 26.03.2017.
 */
public class ClassD implements MethodReplacer {

    private String field6;
    private String field7;

    public ClassD() {
    }

    public ClassD(String field6, String field7) {
        this.field6 = field6;
        this.field7 = field7;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    @Override
    public String toString() {
        return "ClassD{" +
                "field6='" + field6 + '\'' +
                ", field7='" + field7 + '\'' +
                '}';
    }

    public Object reimplement(Object target, Method method, Object[] args)
            throws Throwable {
        System.out.println("replaced method");
        return null;
    }
}
