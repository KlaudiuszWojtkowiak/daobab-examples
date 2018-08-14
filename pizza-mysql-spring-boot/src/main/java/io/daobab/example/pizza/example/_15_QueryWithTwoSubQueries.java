package io.daobab.example.pizza.example;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoIngredient;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaIngredient;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.statement.condition.Operator;

/**
 * 
 * Count pizzas having mozarella ingredient.
 * 
 * Produces one query based on three tables:
 * 
 * select count( * ) from Pizza md1 where md1.pizzaId  in  (select md1.pizzaId  from PizzaIngredient md1 where md1.ingredientId  =  (select md1.ingredientId  from Ingredient md1 where  md1.name  = 'mozarella'))
 * 
 * RESULT:
 * Count pizzas having mozarella : 14 of total: 19
 * 
 * 
 * @author Klaudiusz
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _15_QueryWithTwoSubQueries implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoPizzaIngredient daoPizzaIngredient;
	private @Inject IDaoIngredient daoIngredient;
	
	@Override
	public void test() {
		//Task: Count pizzas having mozarella
		Long count=Select.entityList(daoPizza)
				.whereSelect(daoPizza.colPizzaId(),Operator.IN,Select.fieldList(daoPizzaIngredient.colPizzaId())
						.whereSelect(daoPizzaIngredient.colIngredientId(),Operator.IN,Select.fieldList(daoIngredient.colIngredientId()).where(daoIngredient.colName(),Operator.LIKE,"%mozarella%")))
				.countAny();
		
		//Print result:
		System.out.println("Count pizzas having mozarella : "+count);
	}
	

		public static void main(String[] args) {
			Executor.runTest(_15_QueryWithTwoSubQueries.class);
		}

}
