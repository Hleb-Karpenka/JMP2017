package com.epam.jmp;

import com.epam.jmp.food.Egg;
import com.epam.jmp.interfaces.Ifood;

public class Main {

	public static void main(String[] args) {
		Ifood egg = new Egg(155, "chicken egg");
		Cat cat = new Cat("Ginger", "Murka", 1.5, "Persian");
		
		cat.mew();
		cat.eat(egg); //DRY principle in action
		cat.sleep();  //DRY principle in action

	}

}
