package io.daobab.example.springboot.blank.dao.pizza.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.springboot.blank.dao.pizza.column.IngredientId;
import io.daobab.example.springboot.blank.dao.pizza.column.Name;
import io.daobab.example.springboot.blank.dao.pizza.column.Vegetarian;
import io.daobab.example.springboot.blank.dao.pizza.column.Vegan;
import io.daobab.example.springboot.blank.dao.pizza.column.HotRange;

import io.daobab.model.Table;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Ingredient extends Table implements
	IngredientId<Ingredient>,
	Name<Ingredient>,
	Vegetarian<Ingredient>,
	Vegan<Ingredient>,
	HotRange<Ingredient>,

	PrimaryKey<Ingredient,BigDecimal,IngredientId>
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
	public Column<Ingredient,BigDecimal,IngredientId> colID() {
		return colIngredientId();
	}



}