package io.daobab.example.pizza.example;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.cache.CachedList;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;
import io.daobab.example.pizza.example.dict.DictPizzaName;
import io.daobab.statement.condition.Operator;


@Singleton
public class _24_CacheAsAResultOfReguralQuery implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	

	@Override
	public void test() {
		//Task: Select all pizzas
		CachedList<Pizza> pizzabuffor=Select.all(daoPizza); 
		
		
		//Alternatively:
		// List<Pizza> pizzas=Select.from(daoPizza).result();
		
		//Print result:
		pizzabuffor.forEach(Printer::printPizza);
		
		System.out.println("--------- query in buffer - no sql below");
		
			Select.from(pizzabuffor)
			.where(daoPizza.colName(), Operator.IN,DictPizzaName.MARGHERITA,DictPizzaName.EUROPEAN,DictPizzaName.CARBONARA)
			.consumeEach(Printer::printPizza);
	}


	
		public static void main(String[] args) {
			Executor.runTest(_24_CacheAsAResultOfReguralQuery.class);
		}

}
