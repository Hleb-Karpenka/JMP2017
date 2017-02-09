package com.epam.jmp;

public class Cat extends Animal {
	
	private String breed;
		
	public Cat(String color, String name, double weight, String breed) {
		super(color, name, weight);
		this.breed = breed;
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public void mew(){
		System.out.println( getName() + " said meow" );
	}
	
}
