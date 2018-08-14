package io.daobab.example.pizza.example;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.dao.IDaoIngredient;
import io.daobab.example.pizza.dao.IDaoIngredientPrice;
import io.daobab.example.pizza.dao.IDaoOrderPizza;
import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaIngredient;
import io.daobab.example.pizza.dao.entity.IngredientPrice;
import io.daobab.example.pizza.dao.entity.OrderPizza;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.dao.entity.PizzaIngredient;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.model.ColumnDefinition;
import io.daobab.structure.IDao;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _21_AbstractProgramming implements DaobabExample{
	
	private @Inject IDaoPizza daoPizza;
	private @Inject IDaoIngredient daoIngredient;
	private @Inject IDaoOrderPizza daoOrderPizza;
	private @Inject IDaoPizzaIngredient daoPizzaIngredient;
	private @Inject IDaoIngredientPrice daoIngredientPrice;
	
	
	/**
	 * 
	 * @param dao - dao to retrieve data. Z is an entity of this DAO must have R relation
	 * @param col - common column (unknown table having R relation), must point on the same column of D 
	 * @param val - R realation object
	 * @return
	 */
	private <D extends IDao<Z>,Z extends R,R> List<Z>  findRealted(D dao,ColumnDefinition<? extends R,?,R> col,R val) {
		return Select.entityList(dao)
				.where(col.pointTo(dao),val)
				.result();
	}

	
	
	@Override
	public void test() {
		
		OrderPizza op=Select.entityWhere(daoOrderPizza.colOrderPizzaId(),1);
		Pizza orderedPizza=Select.entityWhere(daoPizza.relPizza(), op);
		
		List<PizzaIngredient> pizzaIngredient=findRealted(daoPizzaIngredient,daoPizza.relPizza(),op);
		System.out.println("The first order - pizza "+orderedPizza.getName()+" with "+pizzaIngredient.size()+" ingredients");
		
		
		PizzaIngredient firstIngredient=pizzaIngredient.get(0);
		
		List<IngredientPrice> ingredientPrice=findRealted(daoIngredientPrice,daoIngredient.relIngredient(),firstIngredient);
		
		System.out.println("First pizza ingredient price for ordered size: ");
		ingredientPrice.forEach(p->System.out.println(p.getPrice()));
		
	}
	


	public static void main(String[] args) {
		Executor.runTest(_21_AbstractProgramming.class);
	}

}
