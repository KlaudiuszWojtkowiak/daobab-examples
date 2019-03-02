package io.daobab.example.daobab_vs_jpa_criteria.base;

import io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.PizzaTables;
import io.daobab.target.database.DataBaseTarget;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;

public interface TestBase extends PizzaTables {

    void daobab();
    void jpa_criteria();

    CriteriaBuilder cb=null;
    Session session=null;

    DataBaseTarget db=null;
}
