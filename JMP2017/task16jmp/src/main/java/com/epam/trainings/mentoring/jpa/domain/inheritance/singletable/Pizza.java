package com.epam.trainings.mentoring.jpa.domain.inheritance.singletable;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;

@Entity
@Table(name = "PIZZA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PIZZA_TYPE")
public class Pizza extends AbstractIdentified {
    @Column(name = "DOUGH")
    private double dough;
    @Enumerated(EnumType.STRING)
    @Column(name = "SIZE")
    private PizzaSize pizzaSize;

    public double getDough() {
        return dough;
    }

    public void setDough(double dough) {
        this.dough = dough;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
}
