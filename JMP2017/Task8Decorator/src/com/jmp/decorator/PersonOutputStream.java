package com.jmp.decorator;

/**
 * Created by Gleb88 on 12.03.2017.
 */
public class PersonOutputStream extends DecoratorW {


    public PersonOutputStream(Writer writer) {
        super(writer);
    }

    @Override
    public String writePerson(Person name) {
        String s = super.writePerson(name);
        char[] c = s.toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        return stringBuilder.toString();
    }
}
