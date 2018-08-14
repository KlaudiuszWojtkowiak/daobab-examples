package io.daobab.example.pizza.example;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoIngredient;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaIngredient;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;
import io.daobab.example.pizza.example.dict.DictPizzaName;
import io.daobab.statement.condition.Operator;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _12_EagerLoadingOneToMany implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoIngredient daoIngredient;
	private @Inject IDaoPizzaIngredient daoPizzaIngredient;
	
	@Override
	public void test() {
		Pizza pizza=Select.entity(daoPizza)
				.where(daoPizza.colName(),DictPizzaName.FARMER)
				.completeEntity( p->p.setIngredients( Select.entityList(daoIngredient)
						.whereSelect(daoIngredient.relIngredient(),Operator.IN, Select.entityList(daoPizzaIngredient)
								.where(daoPizzaIngredient.relPizza(),p))
						.result()))
				.result();
		Printer.printPizza(pizza);

		pizza.getIngredients().forEach(i->Printer.printIngredient(i));
	}
	

	
	public static void main(String[] args) {
		Executor.runTest(_12_EagerLoadingOneToMany.class);
	}

}
