package com.jmp.abstractfactory;

public class Client {
    private AbstractProductA productA;
    private AbstractProductB productB;

    public Client(AbstractFactory factory) {
        productA = factory.createProductA();
        productB = factory.createProductB();
    }

    public void execute() {
        productB.interact(productA);
    }
}
