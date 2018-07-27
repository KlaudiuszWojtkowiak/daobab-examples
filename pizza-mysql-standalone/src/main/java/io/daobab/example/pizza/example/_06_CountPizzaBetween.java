package io.daobab.example.pizza.example;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;


@Singleton
public class _06_CountPizzaBetween implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	
	@Override
	public void test() {
		//Task: Count pizzas between conditions
		Long count=Select.entityList(daoPizza)
				.whereBetween(daoPizza.colPizzaId(),1,6)
				.countAny();
		
		//Print result:
		System.out.println("Count pizzas with between : "+count);
	}
	
	/**
	 Similar Examples:
	  1. Count with two where:
	  
	 		Long count=Select.entityList(daoPizza)
			.where(Where.AND()
					.and(daoPizza.colPizzaId(),Operator.GREATER_THAN,5)
					.and(daoPizza.colPizzaId(),Operator.LESS_THAN,10)
				)
			.countAny();
			System.out.println("Count pizzas with id greater thant 5  and less than 10: "+count);
			
	 */
	

	
		public static void main(String[] args) {
			Executor.runTest(_06_CountPizzaBetween.class);
		}

}
