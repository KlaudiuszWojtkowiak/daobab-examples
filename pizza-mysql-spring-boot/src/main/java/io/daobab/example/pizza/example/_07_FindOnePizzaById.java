package io.daobab.example.pizza.example;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _07_FindOnePizzaById implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	
	@Override
	public void test() {
		//Task: Select one pizza, with id equal '1'
		Pizza p=Select.entity(daoPizza)
				.where(daoPizza.colPizzaId(),6)
				.result();
		
		//Shortly:
//		Pizza p=Select.entityWhere(daoPizza.colPizzaId(),1);
//		Select.entity(daoPizza).where(daoPizza.colPizzaId(),1).consumeResult(Printer::printPizza);
		
		//Print result:
		Printer.printPizza(p);

	}

	
	public static void main(String[] args) {
		Executor.runTest(_07_FindOnePizzaById.class);
	}

}
