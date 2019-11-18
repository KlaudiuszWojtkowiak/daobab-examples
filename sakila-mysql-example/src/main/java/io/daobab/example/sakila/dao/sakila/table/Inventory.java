package io.daobab.example.sakila.dao.sakila.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.sakila.dao.sakila.column.InventoryId;
import io.daobab.example.sakila.dao.sakila.column.FilmId;
import io.daobab.example.sakila.dao.sakila.column.StoreId;
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
public class Inventory extends Table implements 
	InventoryId<Inventory>,
	FilmId<Inventory>,
	StoreId<Inventory>,
	LastUpdate<Inventory>,

	PrimaryKey<Inventory,BigDecimal,InventoryId>
	{

	@Override
	public String getEntityName() {
		return "inventory";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colInventoryId(),
			colFilmId(),
			colStoreId(),
			colLastUpdate()

        );
	}

	@Override
	public Inventory clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	@Override
	public Column<Inventory,BigDecimal,InventoryId> colID() {
		return colInventoryId();
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