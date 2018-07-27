package io.daobab.example.pizza.example;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoIngredient;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaIngredient;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;
import io.daobab.statement.condition.Operator;

/**
 * Select on three tables - get all pizzas having mozarella
 * 
 * Produce one query: 
 * 
 * select md1 from Pizza md1 where md1.pizzaId  in  (select md1.pizzaId  from Pizza md1, PizzaIngredient md2 where md2.ingredientId  =  (select md1.ingredientId  from Ingredient md1 where  md1.name  = 'mozarella'))
 * @author Klaudiusz
 *
 */
@Singleton
public class _18_TrullyObjectRelationalMapping implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoIngredient daoIngredient;
	private @Inject IDaoPizzaIngredient daoPizzaIngredient;
	
	@Override
	public void test() {
		//Task: Make a relational query with two inner queries without any id
		Select.from(daoPizza).whereSelect(daoPizza.relPizza(),Operator.IN,
				Select.from(daoPizzaIngredient).where(daoPizzaIngredient.relIngredient(), 
						Select.entity(daoIngredient).where(daoIngredient.colName(), "mozarella")
						)
				)
		.consumeEach(Printer::printPizza);
	}
	
		public static void main(String[] args) {
			Executor.runTest(_18_TrullyObjectRelationalMapping.class);
		}

}
