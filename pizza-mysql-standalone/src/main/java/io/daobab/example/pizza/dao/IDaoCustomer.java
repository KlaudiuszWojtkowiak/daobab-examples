package io.daobab.example.pizza.dao;

import io.daobab.example.pizza.dao.entity.Customer;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToCustomer;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToName;

public interface IDaoCustomer extends IDaoRelatedToName<Customer>,IDaoRelatedToCustomer<Customer>{


}
