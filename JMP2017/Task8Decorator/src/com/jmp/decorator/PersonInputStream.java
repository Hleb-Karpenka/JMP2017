package com.jmp.decorator;

/**
 * Created by Gleb88 on 12.03.2017.
 */
public class PersonInputStream extends Decorator {


    public PersonInputStream(Reader reader) {
        super(reader);
    }

    @Override
    public Person readPerson(String name) {
        Person p = super.readPerson(name);
        char[] c = p.getName().toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        p.setName(stringBuilder.toString());
        return p;
    }
}
