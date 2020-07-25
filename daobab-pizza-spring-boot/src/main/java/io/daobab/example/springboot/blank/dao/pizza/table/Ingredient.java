package io.daobab.example.springboot.blank.dao.pizza.table;

import io.daobab.example.springboot.blank.dao.pizza.column.*;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class Ingredient extends Table implements
	IngredientId<Ingredient>,
	Name<Ingredient>,
	Vegetarian<Ingredient>,
	Vegan<Ingredient>,
	HotRange<Ingredient>,

        PrimaryKey<Ingredient, BigDecimal,IngredientId>
	{

	@Override
	public String getEntityName() {
		return "ingredient";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colIngredientId(),
			colName(),
			colVegetarian(),
			colVegan(),
			colHotRange()

        );
	}

	@Override
	public Column<Ingredient, BigDecimal,IngredientId> colID() {
		return colIngredientId();
	}



}
