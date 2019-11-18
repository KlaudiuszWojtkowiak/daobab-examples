package io.daobab.example.sakila.dao.sakila.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.sakila.dao.sakila.column.FilmId;
import io.daobab.example.sakila.dao.sakila.column.CategoryId;
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
public class FilmCategory extends Table implements 
	FilmId<FilmCategory>,
	CategoryId<FilmCategory>,
	LastUpdate<FilmCategory>,

	PrimaryKey<FilmCategory,Integer,CategoryId>
	{

	@Override
	public String getEntityName() {
		return "film_category";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colFilmId(),
			colCategoryId(),
			colLastUpdate()

        );
	}

	@Override
	public FilmCategory clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	@Override
	public Column<FilmCategory,Integer,CategoryId> colID() {
		return colCategoryId();
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