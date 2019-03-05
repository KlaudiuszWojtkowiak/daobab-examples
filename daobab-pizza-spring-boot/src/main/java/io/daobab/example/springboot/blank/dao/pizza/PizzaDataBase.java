package io.daobab.example.springboot.blank.dao.pizza;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.daobab.model.Entity;
import io.daobab.target.database.DataBaseTarget;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@Configuration
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PizzaDataBase extends DataBaseTarget implements PizzaTables{

    private static String IP="localhost";
    private static String PORT="3306";
    private static String USER="root";
    private static String PASS="admin";
    private static String SCHEMA="pizza";

    @Override
    protected DataSource initDataSource() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://"+IP+":"+PORT+"/"+SCHEMA+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
        config.setUsername(USER);
        config.setPassword(PASS);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setSchema(SCHEMA);
        return new HikariDataSource( config );
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
