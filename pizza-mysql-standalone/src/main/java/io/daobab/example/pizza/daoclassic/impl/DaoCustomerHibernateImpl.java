package io.daobab.example.pizza.daoclassic.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.daoclassic.IDaoCustomerHibernate;
import io.daobab.example.pizza.daoclassic.entity.CustomerHibernate;
import io.daobab.example.pizza.daoclassic.impl.base.PizzaHibernateAbstractDao;

@Singleton
public class DaoCustomerHibernateImpl extends PizzaHibernateAbstractDao<CustomerHibernate> implements IDaoCustomerHibernate{

}
