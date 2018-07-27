package io.daobab.example.pizza.example;

import javax.inject.Inject;

import io.daobab.example.pizza.dao.IDaoCustomer;
import io.daobab.example.pizza.dao.entity.Customer;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.GeneratorCustomer;
import io.daobab.function.DaoFunctionsSave;

public class _28_SaveEntity  implements DaobabExample{

	private @Inject IDaoCustomer daoCustomer;
	

	@Override
	public void test() {
			//Save generated customer
			Customer cust=GeneratorCustomer.generate();
			DaoFunctionsSave.transactionalSave(daoCustomer, cust);
			System.out.println("Saved entity got id: "+cust.getCustomerId());
	}
	
		public static void main(String[] args) {
			Executor.runTest(_28_SaveEntity.class);
		}


}
