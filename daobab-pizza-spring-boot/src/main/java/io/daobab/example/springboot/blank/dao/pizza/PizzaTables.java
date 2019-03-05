package io.daobab.example.springboot.blank.dao.pizza;

import io.daobab.parser.ParserGeneral;import io.daobab.example.springboot.blank.dao.pizza.table.Customer;
import io.daobab.example.springboot.blank.dao.pizza.table.Ingredient;
import io.daobab.example.springboot.blank.dao.pizza.table.IngredientPrice;
import io.daobab.example.springboot.blank.dao.pizza.table.OrderAdditional;
import io.daobab.example.springboot.blank.dao.pizza.table.OrderPizza;
import io.daobab.example.springboot.blank.dao.pizza.table.Pizza;
import io.daobab.example.springboot.blank.dao.pizza.table.PizzaIngredient;
import io.daobab.example.springboot.blank.dao.pizza.table.PizzaPrice;
import io.daobab.example.springboot.blank.dao.pizza.table.PizzaSize;


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