import io.daobab.Select;
import io.daobab.converter.JsonHandler;
import io.daobab.example.sakila.SpringBootWebApplication;
import io.daobab.example.sakila.dao.sakila.SakilaDataBase;
import io.daobab.example.sakila.dao.sakila.SakilaTables;
import io.daobab.example.sakila.dao.sakila.column.LastUpdate;
import io.daobab.example.sakila.dao.sakila.table.Film;
import io.daobab.model.*;
import io.daobab.statement.condition.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

import static io.daobab.statement.condition.Operator.EQ;
import static io.daobab.statement.condition.Operator.IN;
import static io.daobab.statement.where.base.Where.AND;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootWebApplication.class)
public class DaobabTest implements SakilaTables {

    @Autowired
    private SakilaDataBase db;

    @Test
    public void t01(){

        var actor= Select.one(db,tabActor).where(tabActor.colActorId(),EQ,1).result();

         List<Film> res= Select.many(db,tabFilm)
                 .join(tabFilmActor,tabFilm.colFilmId())
                 .join(tabActor,tabFilmActor.colActorId())
                .where(tabActor.colActorId(),EQ,actor)
                .result();
    }


    @Test
    public void t02(){

        Select.many(db, tabFilm.colTitle(),tabCategory.colNameTypeString1())
                .join(tabAddress,tabCustomer.colAddressId())
                .join(tabCity,tabAddress.colCityId())
                .join(tabRental,tabCustomer.colCustomerId(),AND().and(tabCustomer.colID(),EQ,6))
                .join(tabInventory,tabRental.colInventoryId())
                .join(tabFilm,tabInventory.colFilmId())
                .join(tabFilmCategory,tabFilm.colFilmId())
                .join(tabCategory,tabFilmCategory.colCategoryId(),AND().and(tabCategory.colNameTypeString1(),IN,"Animation","Children","Comedy"))
//                .where(tabCustomer.colID(),EQ,6)
//                .groupBy(tabFilmCategory.colCategoryId())
                .orderBy(new Order().asc(tabCategory.colNameTypeString1()).asc(tabFilm.colTitle()))
                .flat()
                .forEach(this::print);
    }


    @Test
    public <C extends Column<E,String, EntityRelation<E>>,E extends EntityMap & PrimaryKey<E,? extends Number,?> & LastUpdate<E>> void t03(E table, C column){
        String t=a03(tabCustomer.colLastName());

        var last=a04(tabCustomer.colLastUpdate());
    }

    public <C extends Column<E,F,?>,E extends Table & PrimaryKey<E,? extends Number,?> & LastUpdate<E>,F > F a03(C column){
        return Select.one(db, column)
                .orderDescBy(column.getThisEntity().colLastUpdate())
                .result();
    }
    public <C extends Column<E,String,?>,E extends Table & PrimaryKey<E,? extends Number,?> & LastUpdate<E>> void a02(E table){
        Select.many(db, table)
                .orderDescBy(table.colLastUpdate())
                .forEach(this::print);
    }

    public <C extends Column<E,Timestamp,?>,E extends Table>  E a04(C column){
        return Select.one(db, column.getThisEntity())
                .orderDescBy(column)
                .result();
    }


    private void print(JsonHandler obj){
        System.out.println(obj.toJSON());
    }

    private void print(Object obj){
        System.out.println(obj.toString());
    }








}
