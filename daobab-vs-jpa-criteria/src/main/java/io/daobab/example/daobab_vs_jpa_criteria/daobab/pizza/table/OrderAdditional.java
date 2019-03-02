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
public class OrderAdditional extends Table implements
	OrderAdditionalId<OrderAdditional>,
	OrderPizzaId<OrderAdditional>,
	IngredientId<OrderAdditional>,

	PrimaryKey<OrderAdditional,BigDecimal,OrderAdditionalId>
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
	public Column<OrderAdditional,BigDecimal,OrderAdditionalId> colID() {
		return colOrderAdditionalId();
	}



}
