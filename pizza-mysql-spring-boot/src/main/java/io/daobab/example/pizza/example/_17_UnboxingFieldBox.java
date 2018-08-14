package io.daobab.example.pizza.example;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaPrice;
import io.daobab.example.pizza.dao.IDaoPizzaSize;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.model.FieldBox;
import io.daobab.statement.condition.base.Where;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _17_UnboxingFieldBox implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoPizzaPrice daoPizzaPrice;
	private @Inject IDaoPizzaSize daoPizzaSize;
	
	@Override
	public void test() {
		
		FieldBox box=Select.fieldBox(daoPizza.colName(),daoPizzaSize.colName(),daoPizzaPrice.colPrice())
				.where(Where.AND()
						.and(daoPizzaPrice.colPizzaId(),daoPizza.colPizzaId())
						.and(daoPizzaPrice.colPizzaSizeId(),daoPizzaSize.colPizzaSizeId())
						)
				.orderAscBy(daoPizza.colName())
				.result();
		
		box.getRows().forEach(r->{
			System.out.println(
					" Name: "+r.unboxField(daoPizza.colName())+
					" Size: "+r.unboxField(daoPizzaSize.colName())+
					" Price: "+r.unboxField(daoPizzaPrice.colPrice())
					);
		});
	}

	
		public static void main(String[] args) {
			Executor.runTest(_17_UnboxingFieldBox.class);
		}

}
