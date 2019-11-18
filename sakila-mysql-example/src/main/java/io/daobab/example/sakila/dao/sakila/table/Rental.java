package io.daobab.example.sakila.dao.sakila.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.sakila.dao.sakila.column.RentalId;
import io.daobab.example.sakila.dao.sakila.column.RentalDate;
import io.daobab.example.sakila.dao.sakila.column.InventoryId;
import io.daobab.example.sakila.dao.sakila.column.CustomerId;
import io.daobab.example.sakila.dao.sakila.column.ReturnDate;
import io.daobab.example.sakila.dao.sakila.column.StaffId;
import io.daobab.example.sakila.dao.sakila.column.LastUpdate;

import io.daobab.model.Table;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Rental extends Table implements 
	RentalId<Rental>,
	RentalDate<Rental>,
	InventoryId<Rental>,
	CustomerId<Rental>,
	ReturnDate<Rental>,
	StaffId<Rental>,
	LastUpdate<Rental>,

	PrimaryKey<Rental,BigDecimal,RentalId>
	{

	@Override
	public String getEntityName() {
		return "rental";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colRentalId(),
			colRentalDate(),
			colInventoryId(),
			colCustomerId(),
			colReturnDate(),
			colStaffId(),
			colLastUpdate()

        );
	}

	@Override
	public Rental clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	@Override
	public Column<Rental,BigDecimal,RentalId> colID() {
		return colRentalId();
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