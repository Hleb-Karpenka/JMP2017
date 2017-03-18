package com.jmp.ws;


public class Price {

    private String name;
    private String cost;

    public Price(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    public Price() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


}
