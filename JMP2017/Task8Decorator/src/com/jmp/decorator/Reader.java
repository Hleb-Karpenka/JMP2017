package com.jmp.decorator;


/**
 * Created by Gleb88 on 12.03.2017.
 */
public class Reader implements IInputStream {

    @Override
    public Person readPerson(String name) {
        return new Person(name);
    }

    public Reader() {
    }

}
