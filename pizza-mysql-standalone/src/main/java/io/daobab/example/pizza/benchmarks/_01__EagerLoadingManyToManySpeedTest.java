package io.daobab.example.pizza.benchmarks;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.benchmarks.base.ShowTime;
import io.daobab.example.pizza.dao.IDaoIngredientCached;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaCached;
import io.daobab.example.pizza.dao.IDaoPizzaIngredientCached;
import io.daobab.example.pizza.daoclassic.IDaoPizzaHibernate;
import io.daobab.example.pizza.daoclassic.IDaoPizzaHibernateEager;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.dict.DictPizzaName;
import io.daobab.statement.condition.Operator;
import io.daobab.statement.condition.base.Where;


@Singleton
public class _01__EagerLoadingManyToManySpeedTest implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoPizzaCached daoPizzaCached;
	private @Inject IDaoPizzaIngredientCached daoPizzaIngredientCached;
	private @Inject IDaoIngredientCached daoIngredientCached;
	private @Inject IDaoPizzaHibernateEager daoPizzaHibernateEager;
	
	@Override
	public void test() {
		
		ShowTime.compare(
				()-> Select.from(daoPizzaCached).where(daoPizzaCached.colName(), DictPizzaName.CARBONARA)
				.completeEntity(p->{p.setIngredients(Select.from(daoIngredientCached)
						.whereSelect(daoIngredientCached.relIngredient(),Operator.IN,
								Select.from(daoPizzaIngredientCached).where(daoPizzaIngredientCached.relPizza(),p))
						.result());
				}).result(),
				()->daoPizzaHibernateEager.findByProperty("name", DictPizzaName.CARBONARA),
				
				1000);
		
		
		System.out.println("Daobab query returned: "+Select.from(daoPizzaCached)
				.completeEntity(p->{p.setIngredients(Select.from(daoIngredientCached)
						.whereSelect(daoIngredientCached.relIngredient(),Operator.IN,
								Select.from(daoPizzaIngredientCached).where(daoPizzaIngredientCached.relPizza(),p))
						.result());
				}).result().get(0).getIngredients().size()+" connected entities");
		
		
		System.out.println("JPA query returned: "+daoPizzaHibernateEager.findAll().get(0).getIngredients().size() +" connected entities");
		
	}

	
	public static void main(String[] args) {
		Executor.runTest(_01__EagerLoadingManyToManySpeedTest.class);
	}

}
