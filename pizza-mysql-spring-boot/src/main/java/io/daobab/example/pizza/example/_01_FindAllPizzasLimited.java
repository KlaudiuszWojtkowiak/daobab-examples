package io.daobab.example.pizza.example;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;
import io.daobab.statement.condition.Limit;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _01_FindAllPizzasLimited implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	
	@Override
	public void test() {
		Limit dynamicLimit=new Limit();
		dynamicLimit.setOffset(16);
		dynamicLimit.setLimit(8);
		
		Select.from(daoPizza).limitBy(dynamicLimit).consumeEach(Printer::printPizza);
	}
	

	
	public static void main(String[] args) {
		Executor.runTest(_01_FindAllPizzasLimited.class);
	}
}
