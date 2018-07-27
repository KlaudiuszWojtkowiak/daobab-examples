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
import io.daobab.statement.condition.Operator;
import io.daobab.statement.condition.base.Where;

@Singleton
public class _10_FindAllPizzasWithNameHotOrPepperoni implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	
	@Override
	public void test() {
			//Task: Select all pizzas having name like *HOT* or *PEPPERONI*
			List<Pizza> pizzas=Select.entityList(daoPizza)
					.where(Where.OR()
							.or(daoPizza.colName(), Operator.LIKE,"%HOT%")
							.or(daoPizza.colName(), Operator.LIKE,"%PEPPERONI%")
							)
					.result();
			
			//Print result:
			pizzas.forEach(Printer::printPizza);

	}

	public static void main(String[] args) {
		Executor.runTest(_10_FindAllPizzasWithNameHotOrPepperoni.class);
	}

}
