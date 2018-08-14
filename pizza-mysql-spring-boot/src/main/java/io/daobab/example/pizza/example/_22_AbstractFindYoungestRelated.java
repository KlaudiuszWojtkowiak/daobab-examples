package io.daobab.example.pizza.example;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoOrderPizza;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaIngredient;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.dao.entity.PizzaIngredient;
import io.daobab.example.pizza.dao.entity.relation.RelatedToInsertDate;
import io.daobab.example.pizza.dao.entity.relation.RelatedToPizza;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToInsertDate;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizza;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.dict.DictPizzaName;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _22_AbstractFindYoungestRelated implements DaobabExample{

	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoPizzaIngredient daoPizzaIngredient;
	private @Inject IDaoOrderPizza daoOrderPizza;
	
	@Override
	public void test() {
		
		Pizza pepperoni=Select.entityWhere(daoPizza.colName(), DictPizzaName.PEPPERONI);
		PizzaIngredient pi_pepperoni=Select.entityWhere(daoPizzaIngredient.relPizza(),pepperoni);
		
		Date youngest=getYoungestRecordNameRelatedToPizza(daoOrderPizza,pi_pepperoni);
		System.out.println(youngest);
		Date youngest2=getYoungestRecordNameRelatedToPizza(daoOrderPizza,pepperoni);
		System.out.println(youngest2);
	}
	
	private <D extends IDaoRelatedToInsertDate<E>&IDaoRelatedToPizza<E>	
	,E extends RelatedToInsertDate&RelatedToPizza>
	Date  getYoungestRecordNameRelatedToPizza(D dao,RelatedToPizza entityRelated) {
		return Select.field(dao.colInsertDate())
				.where(dao.relPizza(),entityRelated)
				.orderDescBy(dao.colInsertDate())
				.result();
	}

	
	public static void main(String[] args) {
		Executor.runTest(_22_AbstractFindYoungestRelated.class);
	}

}
