package io.daobab.example.springboot.blank.dao.pizza.table;

import io.daobab.example.springboot.blank.dao.pizza.column.*;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class OrderPizza extends Table implements
	OrderPizzaId<OrderPizza>,
	PizzaId<OrderPizza>,
	PizzaSizeId<OrderPizza>,
	DeliverDate<OrderPizza>,
	Price<OrderPizza>,
	InsertDate<OrderPizza>,
	CustomerId<OrderPizza>,

        PrimaryKey<OrderPizza, BigDecimal,OrderPizzaId>
	{

	@Override
	public String getEntityName() {
		return "order_pizza";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colOrderPizzaId(),
			colPizzaId(),
			colPizzaSizeId(),
			colDeliverDate(),
			colPrice(),
			colInsertDate(),
			colCustomerId()

        );
	}

	@Override
	public Column<OrderPizza, BigDecimal,OrderPizzaId> colID() {
		return colOrderPizzaId();
	}



}
