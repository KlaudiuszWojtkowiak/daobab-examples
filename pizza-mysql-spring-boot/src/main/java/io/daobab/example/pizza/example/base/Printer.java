package io.daobab.example.pizza.example.base;

import io.daobab.example.pizza.dao.entity.Ingredient;
import io.daobab.example.pizza.dao.entity.OrderPizza;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.example.nonentity.Client;

public interface Printer {
	
	
	public static void printPizza(Pizza pizza) {
		if (pizza==null) return;
		System.out.println(pizza.getPizzaId()+" "+pizza.getName());
	}

	public static void printIngredient(Ingredient ingredient) {
		if (ingredient==null) return;
		System.out.println(ingredient.getIngredientId()+" "+ingredient.getName());
	}
	
	public static void printClient(Client ingredient) {
		if (ingredient==null) return;
		System.out.println(ingredient.getFirstName()+" "+ingredient.getLastName()+" "+ingredient.getAge());
	}
	
	public static void printOrderPizza(OrderPizza op) {
		if (op==null) return;
		System.out.println(op.getOrderPizzaId()+" "+op.getDeliverDate()+" "+op.getPrice());
	}
	
	public static void printString(String name) {
		System.out.println(name);
	}
}
