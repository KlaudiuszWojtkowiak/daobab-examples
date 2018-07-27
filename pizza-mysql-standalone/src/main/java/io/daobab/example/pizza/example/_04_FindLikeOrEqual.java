package io.daobab.example.pizza.example;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoIngredient;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;
import io.daobab.statement.condition.Operator;
import io.daobab.statement.condition.base.Where;

@Singleton
public class _04_FindLikeOrEqual implements DaobabExample{
	
	private @Inject IDaoIngredient daoIngredient;
	
	@Override
	public void test() {
		
		Select.fieldList(daoIngredient.colName())
				.where(Where.OR()
						.or(daoIngredient.colName(),Operator.LIKE,"%chees%")
						.or(daoIngredient.colName(),Operator.EQUAL,"mozarella")
						)
				.consumeEach(Printer::printString);
	}
		
	public static void main(String[] args) {
		Executor.runTest(_04_FindLikeOrEqual.class);
	}

}
