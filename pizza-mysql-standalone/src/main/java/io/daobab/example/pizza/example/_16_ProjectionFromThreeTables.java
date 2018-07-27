package io.daobab.example.pizza.example;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaPrice;
import io.daobab.example.pizza.dao.IDaoPizzaSize;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.projection.PizzaPriceProjection;
import io.daobab.model.FieldRow;
import io.daobab.statement.condition.Order;
import io.daobab.statement.condition.base.Where;


@Singleton
public class _16_ProjectionFromThreeTables implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoPizzaPrice daoPizzaPrice;
	private @Inject IDaoPizzaSize daoPizzaSize;
	
	@Override
	public void test() {
		
		Select.fieldBox(daoPizza.colName(),daoPizzaSize.colName(),daoPizzaPrice.colPrice())
				.where(Where.AND()
						.and(daoPizzaPrice.colPizzaId(),daoPizza.colPizzaId())
						.and(daoPizzaPrice.colPizzaSizeId(),daoPizzaSize.colPizzaSizeId())
						)
				.orderBy(new Order()
						.asc(daoPizzaPrice.colPrice()) 
						.asc(daoPizza.colName()) 
						)
				.map(this::parseToPizzaPrice)
				.consumeEach((c)->System.out.println(c.toString()));
	}
	
	private PizzaPriceProjection parseToPizzaPrice(FieldRow r) {
		return new PizzaPriceProjection(
				r.unboxField(daoPizza.colName()),
				r.unboxField(daoPizzaSize.colName()),
				r.unboxField(daoPizzaPrice.colPrice())
				);
	}
	
		public static void main(String[] args) {
			Executor.runTest(_16_ProjectionFromThreeTables.class);
		}

}
