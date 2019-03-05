package io.daobab.example.springboot.blank.dao.pizza.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.springboot.blank.dao.pizza.column.IngredientPriceId;
import io.daobab.example.springboot.blank.dao.pizza.column.IngredientId;
import io.daobab.example.springboot.blank.dao.pizza.column.PizzaSizeId;
import io.daobab.example.springboot.blank.dao.pizza.column.Price;

import io.daobab.model.Table;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
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