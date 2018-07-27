package io.daobab.example.pizza.example;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;


@Singleton
public class _00_FindAllPizzas implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	

	@Override
	public void test() {
		//Task: Select all pizzas
		List<Pizza> pizzas=Select.all(daoPizza); 
		
		//Alternatively:
//		 List<Pizza> pizzas=Select.entityList(daoPizza).result();
		
		//Print result:
		pizzas.forEach(Printer::printPizza);
	}
	
	
		public static void main(String[] args) {
				Executor.runTest(_00_FindAllPizzas.class);
		}

}
