package io.daobab.example.pizza.example;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaPrice;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;

@Singleton
public class _13_LazyLoadingOneToMany implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoPizzaPrice daoPizzaPrice;
	
	
	@Override
	public void test() {
		//task: Lazy loading of pizza prices.
			Select.from(daoPizza)
				.completeEntity(p->p.setSupplierPizzaPrice(()->Select.entityListWhere(daoPizzaPrice.relPizza(),p)))
				.consumeEach(p->{
					System.out.println("After a brake new select for id: "+p.getPizzaId());
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					p.getLazyPizzaPriceList().forEach(pp->{
						System.out.println(p.getName()+" price: "+pp.getPrice());
					});
				});
	}
		
	public static void main(String[] args) {
		Executor.runTest(_13_LazyLoadingOneToMany.class);
	}

}
