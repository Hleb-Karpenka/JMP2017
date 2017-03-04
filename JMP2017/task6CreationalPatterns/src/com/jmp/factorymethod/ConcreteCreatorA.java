package com.jmp.factorymethod;

/**
 * Created by Gleb88 on 04.03.2017.
 */
public class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
