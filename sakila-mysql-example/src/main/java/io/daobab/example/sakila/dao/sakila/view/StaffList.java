package io.daobab.example.sakila.dao.sakila.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;

import io.daobab.example.sakila.dao.sakila.column.IdTypeInteger2;
import io.daobab.example.sakila.dao.sakila.column.NameTypeString1;
import io.daobab.example.sakila.dao.sakila.column.Address;
import io.daobab.example.sakila.dao.sakila.column.Zipcode;
import io.daobab.example.sakila.dao.sakila.column.Phone;
import io.daobab.example.sakila.dao.sakila.column.City;
import io.daobab.example.sakila.dao.sakila.column.Country;
import io.daobab.example.sakila.dao.sakila.column.Sid;

import io.daobab.model.Table;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class StaffList extends Table implements 
	IdTypeInteger2<StaffList>,
	NameTypeString1<StaffList>,
	Address<StaffList>,
	Zipcode<StaffList>,
	Phone<StaffList>,
	City<StaffList>,
	Country<StaffList>,
	Sid<StaffList>
	
	{

	@Override
	public String getEntityName() {
		return "staff_list";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colIdTypeInteger2(),
			colNameTypeString1(),
			colAddress(),
			colZipcode(),
			colPhone(),
			colCity(),
			colCountry(),
			colSid()

        );
	}

	@Override
	public StaffList clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	


}