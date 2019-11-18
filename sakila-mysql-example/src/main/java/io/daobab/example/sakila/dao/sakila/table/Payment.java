package io.daobab.example.sakila.dao.sakila.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.sakila.dao.sakila.column.PaymentId;
import io.daobab.example.sakila.dao.sakila.column.CustomerId;
import io.daobab.example.sakila.dao.sakila.column.StaffId;
import io.daobab.example.sakila.dao.sakila.column.RentalId;
import io.daobab.example.sakila.dao.sakila.column.Amount;
import io.daobab.example.sakila.dao.sakila.column.PaymentDate;
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
public class Payment extends Table implements 
	PaymentId<Payment>,
	CustomerId<Payment>,
	StaffId<Payment>,
	RentalId<Payment>,
	Amount<Payment>,
	PaymentDate<Payment>,
	LastUpdate<Payment>,

	PrimaryKey<Payment,Integer,PaymentId>
	{

	@Override
	public String getEntityName() {
		return "payment";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colPaymentId(),
			colCustomerId(),
			colStaffId(),
			colRentalId(),
			colAmount(),
			colPaymentDate(),
			colLastUpdate()

        );
	}

	@Override
	public Payment clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	@Override
	public Column<Payment,Integer,PaymentId> colID() {
		return colPaymentId();
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