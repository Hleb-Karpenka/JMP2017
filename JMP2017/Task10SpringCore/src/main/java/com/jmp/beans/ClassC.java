package com.jmp.beans;

/**
 * Created by Gleb88 on 26.03.2017.
 */
public class ClassC {

    private String field5;
    private ClassD classD;

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public ClassD getClassD() {
        return classD;
    }

    public void setClassD(ClassD classD) {
        this.classD = classD;
    }

    public ClassC(String field5, ClassD classD) {
        this.field5 = field5;
        this.classD = classD;
    }

    public ClassC() {
    }

    @Override
    public String toString() {
        return "ClassC{" +
                "field5='" + field5 + '\'' +
                ", classD=" + classD +
                '}';
    }
}
