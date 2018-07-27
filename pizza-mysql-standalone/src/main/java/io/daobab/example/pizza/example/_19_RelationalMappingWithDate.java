package io.daobab.example.pizza.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoCustomer;
import io.daobab.example.pizza.dao.IDaoOrderPizza;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaSize;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.statement.condition.base.Where;

/**
 * Select on three tables - get all pizzas having mozarella
 * 
 * Produce one query: 
 * 
 * select md1 from Pizza md1 where md1.pizzaId  in  (select md1.pizzaId  from Pizza md1, PizzaIngredient md2 where md2.ingredientId  =  (select md1.ingredientId  from Ingredient md1 where  md1.name  = 'mozarella'))
 * @author Klaudiusz
 *
 */
@Singleton
public class _19_RelationalMappingWithDate implements DaobabExample{
	
	private @Inject IDaoOrderPizza daoOrderPizza;
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoCustomer daoCustomer;
	private @Inject IDaoPizzaSize daoPizzaSize;
	
	
	@Override
	public void test() {
		
		try {
			
			Date fromDate=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2018-01-05 00:00");
			Date toDate=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2018-01-06 00:00");
			
			Long count=Select.entityList(daoOrderPizza)
					.whereBetween(daoOrderPizza.colDeliverDate(),fromDate,toDate)
					.countAny();
		
			System.out.println(count);
			
			Select.fieldBox(daoCustomer.colName(),daoPizza.colName(),daoPizzaSize.colName())
					.where(Where.AND()
						.and(daoOrderPizza.relPizza(),daoPizza.relPizza())
						.and(daoOrderPizza.relCustomer(),daoCustomer.relCustomer())
						.and(daoOrderPizza.relPizzaSize(),daoPizzaSize.relPizzaSize())
						.andBetween(daoOrderPizza.colDeliverDate(),fromDate,toDate))
					.consumeEach(r->{
						System.out.println( r.unboxField(daoCustomer.colName())+" "+r.unboxField(daoPizza.colName())+" "+r.unboxField(daoPizzaSize.colName()) );
					});
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
	}

	
		public static void main(String[] args) {
			Executor.runTest(_19_RelationalMappingWithDate.class);
		}

}
