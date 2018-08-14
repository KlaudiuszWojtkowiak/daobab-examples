package io.daobab.example.pizza.dao.connector;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.daobab.annotation.DataBaseUnit;

public class EntityManagerProducer  implements Serializable {
//	
//	private static final long serialVersionUID = -5985314573150510387L;
//	
//	
//	private EntityManager em;
//	
//	@DataBaseUnit(DictDataBaseUnit.PIZZA_DATABASE)
//	@Produces
//	public EntityManager emProducer() {
//		if (em==null==false) return em;
//		HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.put("hibernate.show_sql", "false");
//        properties.put("hibernate.ejb.entitymanager_factory_name", DictDataBaseUnit.PIZZA_DATABASE);
//        properties.put("hibernate.connection.username", "root");
//        properties.put("hibernate.connection.password", "admin");
//        properties.put("hibernate.connection.pool_size", "5");
//        properties.put("org.hibernate", "ERROR");
//        
////        properties.put("hibernate.connection.url", "jdbc:oracle:thin:@127.0.0.1:1521/xe");
//        
//        properties.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/pizza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
//        
//        
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DictDataBaseUnit.PIZZA_DATABASE,properties);
//	    em= factory.createEntityManager();
//	    return em;
//	}
//	 public void doNothing(@Disposes @DataBaseUnit(DictDataBaseUnit.PIZZA_DATABASE) EntityManager em) {  
//	        // don't call close  
//	    }  
}
