package io.daobab.example.sakila.dao.sakila.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;

import io.daobab.example.sakila.dao.sakila.column.ActorId;
import io.daobab.example.sakila.dao.sakila.column.FirstName;
import io.daobab.example.sakila.dao.sakila.column.LastName;
import io.daobab.example.sakila.dao.sakila.column.FilmInfo;

import io.daobab.model.Table;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class ActorInfo extends Table implements 
	ActorId<ActorInfo>,
	FirstName<ActorInfo>,
	LastName<ActorInfo>,
	FilmInfo<ActorInfo>
	
	{

	@Override
	public String getEntityName() {
		return "actor_info";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colActorId(),
			colFirstName(),
			colLastName(),
			colFilmInfo()

        );
	}

	@Override
	public ActorInfo clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	


}