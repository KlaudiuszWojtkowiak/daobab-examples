package io.daobab.example.pizza.benchmarks;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.benchmarks.base.ShowTime;
import io.daobab.example.pizza.dao.IDaoPizzaCached;
import io.daobab.example.pizza.daoclassic.IDaoPizzaHibernate;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.dict.DictPizzaName;


@Singleton
public class _00__CacheSpeedTest implements DaobabExample{
	
	private @Inject IDaoPizzaCached daoPizzaCached;
	private @Inject IDaoPizzaHibernate daoPizzaHibernate;
	
	@Override
	public void test() {
		
		ShowTime.compareCache(
				()->daoPizzaHibernate.findByProperty("name", DictPizzaName.EUROPEAN),
				()-> Select.entityListWhere(daoPizzaCached.colName(),DictPizzaName.EUROPEAN),
				1000);
		
	}

	
	public static void main(String[] args) {
		Executor.runTest(_00__CacheSpeedTest.class);
	}

}
