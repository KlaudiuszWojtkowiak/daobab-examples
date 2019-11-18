package io.daobab.example.sakila;

import io.daobab.Select;
import io.daobab.example.sakila.dao.sakila.SakilaDataBase;
import io.daobab.example.sakila.dao.sakila.SakilaTables;
import io.daobab.example.sakila.dao.sakila.table.Actor;
import io.daobab.example.sakila.dao.sakila.table.Customer;
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

    @GetMapping("/t01")
    public List<Actor> t01(){
        return Select.from(db,tabActor)
                .where(AND()
                        .and(tabActor.colActorId(),GT,100)
                        .and(tabActor.colActorId(),LT,110)
                )
                .result();
    }

    @GetMapping("/t02")
    public Customer t02(int id){
        return Select.one(db,tabCustomer)
                .where(tabCustomer.colID(),EQ,id)
                .result();
    }


    @GetMapping("/t03")
    public FlatProjection t03(int id){
        return Select.one(db,tabCustomer.colFirstName(),tabCustomer.colLastName(),tabAddress.colCityId(),tabAddress.colPhone())
                .join(tabAddress,tabCustomer.colAddressId())
                .where(tabCustomer.colID(),EQ,id)
                .flat()
                .result();
    }



}
