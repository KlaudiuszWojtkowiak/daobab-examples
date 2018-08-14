package io.daobab.example.pizza.example.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import io.daobab.Select;
import io.daobab.cache.CachedList;
import io.daobab.example.pizza.dao.IDaoCustomer;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaPrice;
import io.daobab.example.pizza.dao.IDaoPizzaSize;
import io.daobab.example.pizza.dao.entity.Customer;
import io.daobab.example.pizza.dao.entity.OrderPizza;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.dao.entity.PizzaPrice;
import io.daobab.example.pizza.dao.entity.PizzaSize;
import io.daobab.statement.condition.base.Where;

public interface GeneratorOrderPizza {
	
	public static List<OrderPizza> generate(IDaoCustomer c,IDaoPizza pizza,IDaoPizzaSize ps,IDaoPizzaPrice pp,int count) {
		List<OrderPizza> rv=new LinkedList<>();
		if (c==null||pizza==null||ps==null||pp==null) return rv;
		
		Random r=new Random();
		
		CachedList<Customer> customers=Select.all(c);
		CachedList<Pizza> pizzas=Select.all(pizza);
		CachedList<PizzaSize> sizes=Select.all(ps);
		CachedList<PizzaPrice> prices=Select.all(pp);
		
		
		for (int i=0;i<count;i++) {
			Customer cust=customers.get(r.nextInt(customers.size()));
			Pizza p=pizzas.get(r.nextInt(pizzas.size()));
			PizzaSize psize=sizes.get(r.nextInt(sizes.size()));
			PizzaPrice ppp=Select.entity(prices).where(Where.AND().and(pp.relPizza(),p).and(ps.relPizzaSize().pointTo(sizes),psize)).result();
			
			System.out.println("generated: "+cust.getName()+" "+p.getName()+" "+psize.getName()+" "+ppp.getPrice());
			
			rv.add(generate(cust,p,psize,ppp));
		}

		
		return rv;
	}
	
	public static OrderPizza generate(Customer c,Pizza pizza,PizzaSize ps,PizzaPrice pp) {
		OrderPizza rv=new OrderPizza();
		rv.setCustomerId(c.getCustomerId());
		rv.setPizzaId(pizza.getPizzaId());
		rv.setPizzaSizeId(ps.getPizzaSizeId());
		rv.setDeliverDate(GeneratorDate2018.generateDate2018());
		rv.setPrice(pp.getPrice());
		rv.setInsertDate(GeneratorDate2018.generateDate2018());
		return rv;
		
	}

}
