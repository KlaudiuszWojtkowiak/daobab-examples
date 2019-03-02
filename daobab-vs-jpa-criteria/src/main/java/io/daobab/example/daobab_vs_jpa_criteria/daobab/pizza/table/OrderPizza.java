package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.column.*;

import io.daobab.model.Table;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class OrderPizza extends Table implements
	OrderPizzaId<OrderPizza>,
	PizzaId<OrderPizza>,
	PizzaSizeId<OrderPizza>,
	DeliverDate<OrderPizza>,
	Price<OrderPizza>,
	InsertDate<OrderPizza>,
	CustomerId<OrderPizza>,

	PrimaryKey<OrderPizza,BigDecimal,OrderPizzaId>
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
	public Column<OrderPizza,BigDecimal,OrderPizzaId> colID() {
		return colOrderPizzaId();
	}



}
