package io.daobab.example.pizza.example;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.Update;
import io.daobab.example.pizza.dao.IDaoOrderPizza;
import io.daobab.example.pizza.dao.entity.OrderPizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.GeneratorDate2018;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _30_UpdateField  implements DaobabExample{

	private @Inject IDaoOrderPizza daoOrderPizza;
	


	
	@Override
	public void test() {
		
		List<OrderPizza> opl=Select.all(daoOrderPizza);
		opl.forEach(c->Update.to(daoOrderPizza)
				.set(daoOrderPizza.colInsertDate(), GeneratorDate2018.generateDate2018()) 
				.where(daoOrderPizza.colOrderPizzaId(),c.getOrderPizzaId())
				.executeUpdateTransactional());
			
	}
	
		public static void main(String[] args) {
			Executor.runTest(_30_UpdateField.class);
		}


}
