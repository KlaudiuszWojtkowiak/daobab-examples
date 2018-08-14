package io.daobab.example.pizza.example;

import java.util.List;

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
import io.daobab.statement.condition.Operator;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _09_FindAllPizzasWithNameHot implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	
	@Override
	public void test() {
			//Task: Select all pizzas having name like *HOT*
			List<Pizza> pizzas=Select.entityList(daoPizza)
					.where(daoPizza.colName(), Operator.LIKE,"%HOT%")
					.result();
			
			//Print result:
			pizzas.forEach(Printer::printPizza);

	}
	
	public static void main(String[] args) {
		Executor.runTest(_09_FindAllPizzasWithNameHot.class);
	}

}
