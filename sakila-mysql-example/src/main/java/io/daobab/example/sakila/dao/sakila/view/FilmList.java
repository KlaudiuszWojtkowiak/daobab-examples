package io.daobab.example.sakila.dao.sakila.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;

import io.daobab.example.sakila.dao.sakila.column.Fid;
import io.daobab.example.sakila.dao.sakila.column.Title;
import io.daobab.example.sakila.dao.sakila.column.Description;
import io.daobab.example.sakila.dao.sakila.column.Category;
import io.daobab.example.sakila.dao.sakila.column.Price;
import io.daobab.example.sakila.dao.sakila.column.Length;
import io.daobab.example.sakila.dao.sakila.column.Rating;
import io.daobab.example.sakila.dao.sakila.column.Actors;

import io.daobab.model.Table;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class FilmList extends Table implements 
	Fid<FilmList>,
	Title<FilmList>,
	Description<FilmList>,
	Category<FilmList>,
	Price<FilmList>,
	Length<FilmList>,
	Rating<FilmList>,
	Actors<FilmList>
	
	{

	@Override
	public String getEntityName() {
		return "film_list";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colFid(),
			colTitle(),
			colDescription(),
			colCategory(),
			colPrice(),
			colLength(),
			colRating(),
			colActors()

        );
	}

	@Override
	public FilmList clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	


}