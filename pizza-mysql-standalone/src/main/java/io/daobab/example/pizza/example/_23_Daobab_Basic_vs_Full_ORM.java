package io.daobab.example.pizza.example;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoCustomer;
import io.daobab.example.pizza.dao.IDaoOrderPizza;
import io.daobab.example.pizza.dao.entity.Customer;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;

@Singleton
public class _23_Daobab_Basic_vs_Full_ORM implements DaobabExample{
	
	private @Inject IDaoOrderPizza daoOrderPizza;
	private @Inject IDaoCustomer daoCustomer;
	
	@Override
	public void test() {
		
		Customer cust=Select.entityWhere(daoCustomer.colName(), "John Smith");
		
		/**
		 * Followed queries provides the same JPQL: 
		 * select md1.deliverDate  from OrderPizza md1 where  md1.customerId  = '1'
		 */
	
		//Classic ORM
		//JPQL: select md1.deliverDate  from OrderPizza md1 where  md1.customerId  = '1'
		Select.fieldList(daoOrderPizza.colDeliverDate())
				.where(daoOrderPizza.colCustomerId(), cust.getCustomerId())    // <--- ID
				.consumeEach(System.out::println);
		
		//Full ORM 
		//JPQL: select md1.deliverDate  from OrderPizza md1 where  md1.customerId  = '1'
		Select.fieldList(daoOrderPizza.colDeliverDate())
				.where(daoOrderPizza.relCustomer(), cust)         //<--- NO ID
				.consumeEach(System.out::println);
		
		
	
	}
	

	public static void main(String[] args) {
		Executor.runTest(_23_Daobab_Basic_vs_Full_ORM.class);
	}

}
