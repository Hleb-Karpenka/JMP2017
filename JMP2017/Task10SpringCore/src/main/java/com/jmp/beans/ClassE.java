package com.jmp.beans;

/**
 * Created by Gleb88 on 26.03.2017.
 */
public class ClassE {

    private String field8;
    private String field9;

    public ClassE() {
    }

    public ClassE(String field8, String field9) {
        this.field8 = field8;
        this.field9 = field9;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    @Override
    public String toString() {
        return "ClassE{" +
                "field8='" + field8 + '\'' +
                ", field9='" + field9 + '\'' +
                '}';
    }

    public String method1() {
        System.out.println("method echo");
        return "";
    }

}
