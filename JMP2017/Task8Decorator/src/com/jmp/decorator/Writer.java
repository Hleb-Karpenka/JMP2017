package com.jmp.decorator;

/**
 * Created by Gleb88 on 12.03.2017.
 */
public class Writer implements IOutputStream {

    @Override
    public String writePerson(Person p) {
        return p.getName();
    }
}
