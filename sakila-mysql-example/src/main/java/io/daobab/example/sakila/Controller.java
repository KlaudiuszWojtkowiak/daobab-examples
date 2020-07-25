package io.daobab.example.sakila;

import io.daobab.Select;
import io.daobab.example.sakila.dao.sakila.SakilaDataBase;
import io.daobab.example.sakila.dao.sakila.SakilaTables;
import io.daobab.example.sakila.dao.sakila.table.Actor;
import io.daobab.example.sakila.dao.sakila.table.Customer;
import io.daobab.example.sakila.dao.sakila.table.Film;
import io.daobab.model.FlatProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.daobab.statement.condition.Operator.*;
import static io.daobab.statement.where.base.Where.AND;

@RestController
@RequestMapping("/test")
public class Controller implements SakilaTables {

    @Autowired
    private SakilaDataBase db;

    @GetMapping("/actorList")
    public List<Actor> actorList(){
        return Select.many(db,tabActor)
                .orderAscBy(tabActor.colID())
                .result();
    }

    @GetMapping("/actorNameById")
    public FlatProjection actorNameById(int actorId){
        return Select.one(db,tabActor.colFirstName(),tabActor.colLastName())
                .where(tabActor.colID(),EQ,actorId)
                .flat()
                .result();
    }

    @GetMapping("/actorById")
    public Actor actorById(int actorId){
        return Select.one(db,tabActor)
                .where(tabActor.colID(),EQ,actorId)
                .result();
    }

    @GetMapping("/actorMovies")
    public List<Film> actorMovies(int actorId){
        return Select.many(db,tabFilm)
                .join(tabFilmActor,tabFilm.colFilmId())
                .join(tabActor,tabFilmActor.colActorId(),
                        AND().and(tabActor.colID(),EQ,actorId))
                .result();
    }


    @GetMapping("/actorFilmCategories")
    public List<String> actorFilmCategories(int actorId){
        return Select.many(db,tabCategory.colNameTypeString1())
                .join(tabFilmCategory,tabCategory.colCategoryId())
                .join(tabFilm,tabFilmCategory.colFilmId())
                .join(tabFilmActor,tabFilm.colFilmId(),AND().and(tabFilmActor.colActorId(),EQ,actorId))
                .result();
    }



}
