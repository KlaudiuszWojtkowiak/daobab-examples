package io.daobab.example.pizza.dao.connector;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.daobab.springjpa.connector.AbstractDataBaseConnector;




/**
 * 
 * 
 * @author Klaudiusz Wojtkowiak
 *
 */
@Configuration
@EnableJpaRepositories(
    basePackages = {"io.daobab.example.pizza.dao.entity","io.daobab.example.pizza.dao.entity"}, 
    entityManagerFactoryRef = "unitEntityManager_collector", 
    transactionManagerRef = "unitTransactionManager_collector"
)
@EnableTransactionManagement
public class DataBaseCollectorConnector extends AbstractDataBaseConnector {
	
	@Primary
	@Bean
    public LocalContainerEntityManagerFactoryBean unitEntityManager_collector() {
		return unitEntityManager();
	}
     
	@Primary
    @Bean
    public DataSource unitDataSource_collector() {
    	return unitDataSource();
    }
 
    @Primary
    @Bean
    public PlatformTransactionManager unitTransactionManager_collector() {
    	return unitTransactionManager();
    }
 

	@Override
	public String getUnitName() {
		return DictDataBaseUnit.PIZZA_DATABASE;
	}



	@Override
	public String[] getUnitPackagesToScan() {
		return new String[] { "io.daobab.example.pizza.dao.entity" };
	}

	


	
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }


}