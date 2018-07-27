package io.daobab.example.pizza.example;

import javax.inject.Inject;

import io.daobab.example.pizza.dao.IDaoCustomer;
import io.daobab.example.pizza.dao.IDaoOrderPizza;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaPrice;
import io.daobab.example.pizza.dao.IDaoPizzaSize;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.GeneratorOrderPizza;
import io.daobab.function.DaoFunctionsSave;

public class _29_SaveEntityCollectionInOneTransaction  implements DaobabExample{

	private @Inject IDaoOrderPizza daoOrderPizza;
	private @Inject IDaoCustomer daoCustomer;
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoPizzaSize daoPizzaSize;
	private @Inject IDaoPizzaPrice daoPizzaPrice;
	

	@Override
	public void test() {
		
		DaoFunctionsSave.transactionalSaveCollection(daoOrderPizza, GeneratorOrderPizza.generate(daoCustomer, daoPizza, daoPizzaSize, daoPizzaPrice, 10000));

			
	}
	
		public static void main(String[] args) {
			Executor.runTest(_29_SaveEntityCollectionInOneTransaction.class);
		}


}
