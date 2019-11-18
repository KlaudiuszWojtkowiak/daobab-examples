package io.daobab.example.sakila.dao.sakila.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.sakila.dao.sakila.column.AddressId;
import io.daobab.example.sakila.dao.sakila.column.Address2;
import io.daobab.example.sakila.dao.sakila.column.District;
import io.daobab.example.sakila.dao.sakila.column.CityId;
import io.daobab.example.sakila.dao.sakila.column.PostalCode;
import io.daobab.example.sakila.dao.sakila.column.Phone;
import io.daobab.example.sakila.dao.sakila.column.Location;
import io.daobab.example.sakila.dao.sakila.column.LastUpdate;

import io.daobab.model.Table;

import java.lang.Integer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Address extends Table implements 
	AddressId<Address>,
	io.daobab.example.sakila.dao.sakila.column.Address<Address>,
	Address2<Address>,
	District<Address>,
	CityId<Address>,
	PostalCode<Address>,
	Phone<Address>,
	Location<Address>,
	LastUpdate<Address>,

	PrimaryKey<Address,Integer,AddressId>
	{

	@Override
	public String getEntityName() {
		return "address";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colAddressId(),
			colAddress(),
			colAddress2(),
			colDistrict(),
			colCityId(),
			colPostalCode(),
			colPhone(),
			colLocation(),
			colLastUpdate()

        );
	}

	@Override
	public Address clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	@Override
	public Column<Address,Integer,AddressId> colID() {
		return colAddressId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		PrimaryKey other = (PrimaryKey) obj;
		return Objects.equals(getId(), other.getId());
	}




}