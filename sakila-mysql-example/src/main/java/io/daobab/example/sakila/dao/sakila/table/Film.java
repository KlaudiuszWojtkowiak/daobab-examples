package io.daobab.example.sakila.dao.sakila.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.example.sakila.dao.sakila.column.FilmId;
import io.daobab.example.sakila.dao.sakila.column.Title;
import io.daobab.example.sakila.dao.sakila.column.Description;
import io.daobab.example.sakila.dao.sakila.column.ReleaseYear;
import io.daobab.example.sakila.dao.sakila.column.LanguageId;
import io.daobab.example.sakila.dao.sakila.column.OriginalLanguageId;
import io.daobab.example.sakila.dao.sakila.column.RentalDuration;
import io.daobab.example.sakila.dao.sakila.column.RentalRate;
import io.daobab.example.sakila.dao.sakila.column.Length;
import io.daobab.example.sakila.dao.sakila.column.ReplacementCost;
import io.daobab.example.sakila.dao.sakila.column.Rating;
import io.daobab.example.sakila.dao.sakila.column.SpecialFeatures;
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
public class Film extends Table implements 
	FilmId<Film>,
	Title<Film>,
	Description<Film>,
	ReleaseYear<Film>,
	LanguageId<Film>,
	OriginalLanguageId<Film>,
	RentalDuration<Film>,
	RentalRate<Film>,
	Length<Film>,
	ReplacementCost<Film>,
	Rating<Film>,
	SpecialFeatures<Film>,
	LastUpdate<Film>,

	PrimaryKey<Film,Integer,FilmId>
	{

	@Override
	public String getEntityName() {
		return "film";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colFilmId(),
			colTitle(),
			colDescription(),
			colReleaseYear(),
			colLanguageId(),
			colOriginalLanguageId(),
			colRentalDuration(),
			colRentalRate(),
			colLength(),
			colReplacementCost(),
			colRating(),
			colSpecialFeatures(),
			colLastUpdate()

        );
	}

	@Override
	public Film clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	@Override
	public Column<Film,Integer,FilmId> colID() {
		return colFilmId();
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