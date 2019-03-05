package io.daobab.example.pizza.table;

import io.daobab.example.pizza.column.IngredientId;
import io.daobab.example.pizza.column.IngredientPriceId;
import io.daobab.example.pizza.column.PizzaSizeId;
import io.daobab.example.pizza.column.Price;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class IngredientPrice extends Table implements
	IngredientPriceId<IngredientPrice>,
	IngredientId<IngredientPrice>,
	PizzaSizeId<IngredientPrice>,
	Price<IngredientPrice>,

	PrimaryKey<IngredientPrice,BigDecimal,IngredientPriceId>
	{

	@Override
	public String getEntityName() {
		return "ingredient_price";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colIngredientPriceId(),
			colIngredientId(),
			colPizzaSizeId(),
			colPrice()

        );
	}

	@Override
	public Column<IngredientPrice,BigDecimal,IngredientPriceId> colID() {
		return colIngredientPriceId();
	}



}
