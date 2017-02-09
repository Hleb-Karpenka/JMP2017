package com.epam.jmp;

import com.epam.jmp.interfaces.Ifood;

public class Animal {
	
	private String color;
	private String name;
	private double weight;	
			
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(String color, String name, double weight) {
		super();
		this.color = color;
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void sleep()
	{
		System.out.println(name + "is fast asleep");
	}			
	
	public void eat(Ifood food){
		System.out.println(name + " eats the " + food.getName()+ " and get calories: " + food.getCalories());
	}
	
}
