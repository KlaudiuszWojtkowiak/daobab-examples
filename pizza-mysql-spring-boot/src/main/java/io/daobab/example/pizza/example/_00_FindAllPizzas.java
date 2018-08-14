package io.daobab.example.pizza.example;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Printer;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _00_FindAllPizzas implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	
	@PostConstruct
	@Override
	public void test() {
		//Task: Select all pizzas
		List<Pizza> pizzas=Select.all(daoPizza); 
		
		//Alternatively:
//		 List<Pizza> pizzas=Select.entityList(daoPizza).result();
		
		//Print result:
		pizzas.forEach(Printer::printPizza);
		
//		try {
//			Thread.currentThread().sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	


}
