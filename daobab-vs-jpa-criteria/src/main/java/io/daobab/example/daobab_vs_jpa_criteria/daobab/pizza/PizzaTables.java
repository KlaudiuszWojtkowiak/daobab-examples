package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza;

import io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.table.*;
import io.daobab.parser.ParserGeneral;



public interface PizzaTables extends ParserGeneral{

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
