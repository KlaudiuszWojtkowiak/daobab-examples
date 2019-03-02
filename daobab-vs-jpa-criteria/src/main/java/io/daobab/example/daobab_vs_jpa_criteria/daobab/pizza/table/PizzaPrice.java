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
