package com.jmp.beans;

/**
 * Created by Gleb88 on 26.03.2017.
 */
public class ClassF {

    private String field0;

    public String getField0() {
        return field0;
    }

    public void setField0(String field0) {
        this.field0 = field0;
    }

    public ClassF(String field0) {

        this.field0 = field0;
    }

    public ClassF() {

    }

    @Override
    public String toString() {
        return "ClassF{" +
                "field0='" + field0 + '\'' +
                '}';
    }

    public void init(){
        System.out.println("init method");
    }
}
