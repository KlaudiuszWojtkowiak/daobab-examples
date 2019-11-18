package io.daobab.example.sakila.dao.sakila.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.sakila.dao.sakila.column.StaffId;
import io.daobab.example.sakila.dao.sakila.column.FirstName;
import io.daobab.example.sakila.dao.sakila.column.LastName;
import io.daobab.example.sakila.dao.sakila.column.AddressId;
import io.daobab.example.sakila.dao.sakila.column.Picture;
import io.daobab.example.sakila.dao.sakila.column.Email;
import io.daobab.example.sakila.dao.sakila.column.StoreId;
import io.daobab.example.sakila.dao.sakila.column.Active;
import io.daobab.example.sakila.dao.sakila.column.Username;
import io.daobab.example.sakila.dao.sakila.column.Password;
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
public class Staff extends Table implements 
	StaffId<Staff>,
	FirstName<Staff>,
	LastName<Staff>,
	AddressId<Staff>,
	Picture<Staff>,
	Email<Staff>,
	StoreId<Staff>,
	Active<Staff>,
	Username<Staff>,
	Password<Staff>,
	LastUpdate<Staff>,

	PrimaryKey<Staff,Integer,StaffId>
	{

	@Override
	public String getEntityName() {
		return "staff";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colStaffId(),
			colFirstName(),
			colLastName(),
			colAddressId(),
			colPicture(),
			colEmail(),
			colStoreId(),
			colActive(),
			colUsername(),
			colPassword(),
			colLastUpdate()

        );
	}

	@Override
	public Staff clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	@Override
	public Column<Staff,Integer,StaffId> colID() {
		return colStaffId();
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