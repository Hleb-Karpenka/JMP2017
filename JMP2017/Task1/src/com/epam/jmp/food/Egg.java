package com.epam.jmp.food;

import com.epam.jmp.interfaces.Ifood;

public class Egg implements Ifood{

	private double calorie;
	private String name;
			
	public Egg(double calorie, String name) {
		super();
		this.calorie = calorie;
		this.name = name;
	}

	@Override
	public double getCalories() {
		return this.calorie;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
