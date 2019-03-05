package io.daobab.example.pizza;

import io.daobab.example.pizza.table.*;
import io.daobab.parser.ParserGeneral;


public interface PizzaTables extends ParserGeneral {

	Customer tabCustomer= new Customer();
	Ingredient tabIngredient= new Ingredient();
	IngredientPrice tabIngredientPrice= new IngredientPrice();
	OrderAdditional tabOrderAdditional= new OrderAdditional();
	OrderPizza tabOrderPizza= new OrderPizza();
	Pizza tabPizza= new Pizza();
	PizzaIngredient tabPizzaIngredient= new PizzaIngredient();
	PizzaPrice tabPizzaPrice= new PizzaPrice();
	PizzaSize tabPizzaSize= new PizzaSize();


}
