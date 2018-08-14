package io.daobab.example.pizza.example;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.cache.CachedList;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _25_CacheFilteredByPredicates implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	
	@Override
	public void test() {
		//Task: return pizzas haven 'O' in name
		CachedList<Pizza> pizzaCache=Select.all(daoPizza); 
		
		pizzaCache.filter( (e)->e.getName().contains("O"))
		.forEach(Printer::printPizza);
	}


	
		public static void main(String[] args) {
			Executor.runTest(_25_CacheFilteredByPredicates.class);
		}

}
