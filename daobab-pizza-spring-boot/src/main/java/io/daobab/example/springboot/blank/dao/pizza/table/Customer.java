package io.daobab.example.springboot.blank.dao.pizza.table;

import io.daobab.example.springboot.blank.dao.pizza.column.*;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


//@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Customer extends Table implements
	CustomerId<Customer>,
	Name<Customer>,
	Adress<Customer>,
	Phone<Customer>,
	InsertDate<Customer>,

        PrimaryKey<Customer, BigDecimal,CustomerId>
	{

	@Override
	public String getEntityName() {
		return "customer";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colCustomerId(),
			colName(),
			colAdress(),
			colPhone(),
			colInsertDate()

        );
	}

	@Override
	public Column<Customer, BigDecimal,CustomerId> colID() {
		return colCustomerId();
	}



}
