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
import io.daobab.example.pizza.example.base.Printer;
import io.daobab.example.pizza.example.dict.DictPizzaName;
import io.daobab.statement.condition.base.Where;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _11_FindPizzaIngredients implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoIngredient daoIngredient;
	private @Inject IDaoPizzaIngredient daoPizzaIngredient;
	
	@Override
	public void test() {
		
		//Task: Select pizza ingredients, order them by name
		Select.from(daoIngredient)
				.where(Where.AND()
					.and(daoPizza.colName(),DictPizzaName.TEXAS)
					.and(daoPizza.colPizzaId(),daoPizzaIngredient.colPizzaId())
					.and(daoPizzaIngredient.colIngredientId(),daoIngredient.colIngredientId())
				).orderAscBy(daoIngredient.colName())
		.consumeEach(Printer::printIngredient);
	}
		

	public static void main(String[] args) {
		Executor.runTest(_11_FindPizzaIngredients.class);
	}
}
