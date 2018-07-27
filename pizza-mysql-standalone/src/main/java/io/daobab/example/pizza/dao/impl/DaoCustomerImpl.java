package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoCustomer;
import io.daobab.example.pizza.dao.entity.Customer;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;

@Singleton
public class DaoCustomerImpl extends PizzaAbstractDao<Customer> implements IDaoCustomer{

	private static final long serialVersionUID = 1L;

}
