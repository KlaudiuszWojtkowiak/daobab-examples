package io.daobab.example.pizza;


import com.mysql.cj.jdbc.MysqlDataSource;
import io.daobab.model.Entity;
import io.daobab.target.database.DataBaseTarget;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;


public class PizzaDataBase extends DataBaseTarget implements PizzaTables{
    @Override
    protected DataSource initDataSource() {
        setEnabledLogQueries(true);
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("admin");
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/pizza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        return dataSource;
    }



    @Override
    public List<Entity> initTables() {
        return Arrays.asList(
			tabCustomer,
			tabIngredient,
			tabIngredientPrice,
			tabOrderAdditional,
			tabOrderPizza,
			tabPizza,
			tabPizzaIngredient,
			tabPizzaPrice,
			tabPizzaSize

        );
    }


}
