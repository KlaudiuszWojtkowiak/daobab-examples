package io.daobab.example.pizza.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.cache.CachedList;
import io.daobab.example.pizza.dao.IDaoOrderPizza;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.entity.OrderPizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.statement.condition.Operator;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _20_QueryWithCachedInnerQuery implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoOrderPizza daoOrderPizza;
	
	@Override
	public void test() {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date fromDate=null;
		Date toDate=null;
		try {
			fromDate = sdf.parse("2018-01-01");
			toDate=sdf.parse("2018-01-02");
		} catch (ParseException e) {e.printStackTrace();}
		
		 
		// Create buffer
		CachedList<OrderPizza> ordersbuffer=Select.entityList(daoOrderPizza).whereBetween(daoOrderPizza.colDeliverDate(), fromDate, toDate).result();
		
		//Classic Database query (both tables not cached)
		//JPQL: select md1.name  from Pizza md1 where md1.pizzaId  in  (select md1.pizzaId  from OrderPizza md1 where  ( md1.deliverDate  > '2018-01-01 00:00:00' and  md1.deliverDate  < '2018-01-02 00:00:00'))
		Select.fieldList(daoPizza.colName())
				.whereSelect(daoPizza.colPizzaId(),Operator.IN,
						Select.fieldList(daoOrderPizza.colPizzaId()).whereBetween(daoOrderPizza.colDeliverDate(), fromDate, toDate))
				.consumeEach(System.out::println);
		
		//Inner query selected from cache
		//JPQL: select md1.name  from Pizza md1 where md1.pizzaId  in ('5','8','9','19','10','19','14','11','15','4','5','19','7','12','15','7','6','13','13','14','10')
		Select.fieldList(daoPizza.colName())
				.whereSelect(daoPizza.colPizzaId(),Operator.IN,
						Select.fieldList(ordersbuffer,daoOrderPizza.colPizzaId()).unique())
				.consumeEach(System.out::println);
		
		

	}
	

	public static void main(String[] args) {
		Executor.runTest(_20_QueryWithCachedInnerQuery.class);
	}

}
