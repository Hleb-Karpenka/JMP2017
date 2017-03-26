package com.jmp.beans;

/**
 * Created by Gleb88 on 26.03.2017.
 */
public class ClassB {

    private String field3;
    private String field4;

    public ClassB() {
    }

    public ClassB(String field1, String field2) {
        this.field3 = field1;
        this.field4 = field2;
    }

    public String getField1() {
        return field3;
    }

    public void setField1(String field1) {
        this.field3 = field1;
    }

    public String getField2() {
        return field4;
    }

    public void setField2(String field2) {
        this.field4 = field2;
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "field1='" + field3 + '\'' +
                ", field2='" + field4 + '\'' +
                '}';
    }
}
