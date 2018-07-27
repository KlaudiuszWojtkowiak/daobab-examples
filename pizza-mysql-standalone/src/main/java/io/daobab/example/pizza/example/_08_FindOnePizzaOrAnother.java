package io.daobab.example.pizza.example;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;
import io.daobab.example.pizza.example.dict.DictPizzaName;
import io.daobab.statement.condition.Operator;

@Singleton
public class _08_FindOnePizzaOrAnother implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	
	@Override
	public void test() {
			//Task: Select two pizzas by name
		Select.from(daoPizza)
				.where(daoPizza.colName(),Operator.IN,DictPizzaName.CARBONARA, DictPizzaName.EUROPEAN)
				.consumeEach(Printer::printPizza);
		
		
		/**
		 *  Alternativ:
		 
		 		List<Pizza> pizzas=Select.from(daoPizza)
				.where(Where.OR()
						.or(daoPizza.colName(), DictPizzaName.CARBONARA)
						.or(daoPizza.colName(), DictPizzaName.EUROPEAN)
						)
				.result();
		
		//Print result:
		pizzas.forEach(Printer::printPizza);
		 
		 
		 */

	}
	
	public static void main(String[] args) {
		Executor.runTest(_08_FindOnePizzaOrAnother.class);
	}

}
