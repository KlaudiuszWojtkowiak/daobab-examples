package io.daobab.example.springboot.blank.dao.pizza.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.springboot.blank.dao.pizza.column.PizzaId;
import io.daobab.example.springboot.blank.dao.pizza.column.Name;
import io.daobab.example.springboot.blank.dao.pizza.column.Description;

import io.daobab.model.Table;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Pizza extends Table implements
	PizzaId<Pizza>,
	Name<Pizza>,
	Description<Pizza>,

	PrimaryKey<Pizza,BigDecimal,PizzaId>
	{

	@Override
	public String getEntityName() {
		return "pizza";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colPizzaId(),
			colName(),
			colDescription()

        );
	}

	@Override
	public Column<Pizza,BigDecimal,PizzaId> colID() {
		return colPizzaId();
	}



}