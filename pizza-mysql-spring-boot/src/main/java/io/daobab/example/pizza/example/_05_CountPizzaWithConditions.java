package io.daobab.example.pizza.example;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.statement.condition.Operator;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _05_CountPizzaWithConditions implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	
	@Override
	public void test() {
		//Task: Count pizzas with conditions
		
		
		
		Long count=Select.from(daoPizza)
				.where(daoPizza.colPizzaId(),Operator.GREATER_THAN,5)
				.countAny();
		
		
		
		
		
		
		//Print result:
		System.out.println("Count pizzas with id greater thant 5 : "+count);
	}
	
	/**
	 Similar Examples:
	  1. Count with two where:
	  
	 		Long count=Select.from(daoPizza)
			.where(Where.AND()
					.and(daoPizza.colPizzaId(),Operator.GREATER_THAN,5)
					.and(daoPizza.colPizzaId(),Operator.LESS_THAN,10)
				)
			.countAny();
			System.out.println("Count pizzas with id greater thant 5  and less than 10: "+count);
			
	 */
	

	
		public static void main(String[] args) {
			Executor.runTest(_05_CountPizzaWithConditions.class);
		}

}
