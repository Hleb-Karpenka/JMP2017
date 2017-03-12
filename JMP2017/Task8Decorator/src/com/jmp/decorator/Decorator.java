package com.jmp.decorator;

/**
 * Created by Gleb88 on 12.03.2017.
 */
public abstract class Decorator implements IInputStream  {
    protected Reader reader;

    public Decorator(Reader reader) {
        this.reader = reader;
    }

    @Override
    public Person readPerson(String name){
        return reader.readPerson(name);
    }

}
