package io.daobab.example.pizza.table;

import io.daobab.example.pizza.column.Cm;
import io.daobab.example.pizza.column.Name;
import io.daobab.example.pizza.column.PizzaSizeId;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class PizzaSize extends Table implements
	PizzaSizeId<PizzaSize>,
	Cm<PizzaSize>,
	Name<PizzaSize>,

	PrimaryKey<PizzaSize,BigDecimal,PizzaSizeId>
	{

	@Override
	public String getEntityName() {
		return "pizza_size";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colPizzaSizeId(),
			colCm(),
			colName()

        );
	}

	@Override
	public Column<PizzaSize,BigDecimal,PizzaSizeId> colID() {
		return colPizzaSizeId();
	}



}
