package io.daobab.example.pizza.example;

import java.util.LinkedList;
import java.util.List;

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
import io.daobab.statement.condition.Order;
import io.daobab.statement.condition.base.Where;


@Singleton
public class _26_CacheFilteredByWhere implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;

	
	@Override
	public void test() {
		//Task: Select all pizzas
		CachedList<Pizza> pizzas=Select.all(daoPizza); 
		
		
		//Alternatively:
		// List<Pizza> pizzas=Select.from(daoPizza).result();
		
		//Print buffer:
		pizzas.forEach(Printer::printPizza);
		
		System.out.println("--------- query below");
		
		List<String> names=new LinkedList<>();
		names.add(DictPizzaName.MARGHERITA);
		names.add(DictPizzaName.EUROPEAN);
		
		
		pizzas.filterWhere(Where.AND()
				.and(daoPizza.colPizzaId(), Operator.IN, pizzas.filterWhere(Where.AND()
				.andBetween(daoPizza.colPizzaId(), 2, 6)) ))
		.orderBy(new Order().asc(daoPizza.colName()))
		.forEach(Printer::printPizza);
	}


	
		public static void main(String[] args) {
			Executor.runTest(_26_CacheFilteredByWhere.class);
		}

}
