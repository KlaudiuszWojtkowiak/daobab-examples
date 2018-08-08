package io.daobab.example.pizza.example;

import javax.inject.Inject;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoOrderPizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;

public class _32_Pagination  implements DaobabExample{
	
	private @Inject IDaoOrderPizza daoOrderPizza;
	
	private static final int ELEMENTS_ON_PAGE=5;

	@Override
	public void test() {
		
		for (int i=0;i<5;i++) {
			System.out.println("Take data for page "+i+" ....");
			
			Select.from(daoOrderPizza)
				.orderDescBy(daoOrderPizza.colDeliverDate())
				.page(i, ELEMENTS_ON_PAGE)
				.consumeEach(Printer::printOrderPizza);
			
			System.out.println("...litle brake...");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
		public static void main(String[] args) {
			Executor.runTest(_32_Pagination.class);
		}


}
