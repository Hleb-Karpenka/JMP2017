package com.jmp.decorator;

/**
 * Created by Gleb88 on 12.03.2017.
 */
public class DecoratorW implements IOutputStream {
    protected Writer writer;

    public DecoratorW(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String writePerson(Person p) {
        return writer.writePerson(p);
    }

}
