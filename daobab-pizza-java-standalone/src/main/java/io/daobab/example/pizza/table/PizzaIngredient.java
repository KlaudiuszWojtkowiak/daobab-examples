package io.daobab.example.pizza.table;

import io.daobab.example.pizza.column.IngredientId;
import io.daobab.example.pizza.column.PizzaId;
import io.daobab.example.pizza.column.PizzaIngredientId;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class PizzaIngredient extends Table implements
	PizzaIngredientId<PizzaIngredient>,
	PizzaId<PizzaIngredient>,
	IngredientId<PizzaIngredient>,

	PrimaryKey<PizzaIngredient,BigDecimal,PizzaIngredientId>
	{

	@Override
	public String getEntityName() {
		return "pizza_ingredient";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colPizzaIngredientId(),
			colPizzaId(),
			colIngredientId()

        );
	}

	@Override
	public Column<PizzaIngredient,BigDecimal,PizzaIngredientId> colID() {
		return colPizzaIngredientId();
	}



}
