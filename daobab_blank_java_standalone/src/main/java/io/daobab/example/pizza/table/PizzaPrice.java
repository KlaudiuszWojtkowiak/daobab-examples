package io.daobab.example.pizza.table;

import io.daobab.example.pizza.column.PizzaId;
import io.daobab.example.pizza.column.PizzaPriceId;
import io.daobab.example.pizza.column.PizzaSizeId;
import io.daobab.example.pizza.column.Price;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class PizzaPrice extends Table implements
	PizzaPriceId<PizzaPrice>,
	PizzaId<PizzaPrice>,
	PizzaSizeId<PizzaPrice>,
	Price<PizzaPrice>,

	PrimaryKey<PizzaPrice,BigDecimal,PizzaPriceId>
	{

	@Override
	public String getEntityName() {
		return "pizza_price";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colPizzaPriceId(),
			colPizzaId(),
			colPizzaSizeId(),
			colPrice()

        );
	}

	@Override
	public Column<PizzaPrice,BigDecimal,PizzaPriceId> colID() {
		return colPizzaPriceId();
	}



}
