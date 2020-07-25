package io.daobab.example.springboot.blank.dao.pizza.table;

import io.daobab.example.springboot.blank.dao.pizza.column.*;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class OrderAdditional extends Table implements
	OrderAdditionalId<OrderAdditional>,
	OrderPizzaId<OrderAdditional>,
	IngredientId<OrderAdditional>,

        PrimaryKey<OrderAdditional, BigDecimal,OrderAdditionalId>
	{

	@Override
	public String getEntityName() {
		return "order_additional";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colOrderAdditionalId(),
			colOrderPizzaId(),
			colIngredientId()

        );
	}

	@Override
	public Column<OrderAdditional, BigDecimal,OrderAdditionalId> colID() {
		return colOrderAdditionalId();
	}



}
