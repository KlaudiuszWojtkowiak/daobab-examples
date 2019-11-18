package io.daobab.example.sakila.dao.sakila;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.daobab.model.Entity;
import io.daobab.target.database.DataBaseTarget;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;


@Component
public class SakilaDataBase extends DataBaseTarget implements SakilaTables{



	private static String IP="localhost";
	private static String PORT="3306";
	private static String USER="root";
	private static String PASS="admin";
	private static String SCHEMA="sakila";

	@Override
    protected DataSource initDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://"+IP+":"+PORT+"/"+SCHEMA+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
		config.setUsername(USER);
		config.setPassword(PASS);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.addDataSourceProperty("logging.level.com.zaxxer.hikari.HikariConfig", "INFO");
		config.setSchema(SCHEMA);
		return new HikariDataSource( config );
    }



    @Override
    public List<Entity> initTables() {
        return Arrays.asList(
			tabActor,
			tabAddress,
			tabCategory,
			tabCity,
			tabCountry,
			tabCustomer,
			tabFilm,
			tabFilmActor,
			tabFilmCategory,
			tabFilmText,
			tabInventory,
			tabLanguage,
			tabPayment,
			tabRental,
			tabStaff,
			tabStore,
			viewActorInfo,
			viewCustomerList,
			viewFilmList,
			viewNicerButSlowerFilmList,
			viewSalesByFilmCategory,
			viewSalesByStore,
			viewStaffList

        );
    }

	@Override
	public boolean isEnabledLogQueries() {
		return true;
	}
}