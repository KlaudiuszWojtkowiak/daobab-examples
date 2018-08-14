package io.daobab.example.pizza.dao.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.annotation.DataBaseUnit;
import io.daobab.example.pizza.dao.IDaoCustomer;
import io.daobab.example.pizza.dao.connector.DictDataBaseUnit;
import io.daobab.example.pizza.dao.entity.Customer;
import io.daobab.springjpa.AbstractSpringDao;

@DataBaseUnit(DictDataBaseUnit.PIZZA_DATABASE)
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DaoCustomerImpl extends AbstractSpringDao<Customer> implements IDaoCustomer{

	private static final long serialVersionUID = 1L;

}
