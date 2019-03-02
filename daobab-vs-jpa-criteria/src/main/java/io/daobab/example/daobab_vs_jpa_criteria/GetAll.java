package io.daobab.example.daobab_vs_jpa_criteria;

import io.daobab.Select;
import io.daobab.example.daobab_vs_jpa_criteria.base.TestBase;
import io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.table.Pizza;
import io.daobab.example.daobab_vs_jpa_criteria.jpa.entity._Pizza;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GetAll implements TestBase {


    @Override
    public void daobab() {
       List<Pizza> results= Select.all(db,tabPizza);
    }

    @Override
    public void jpa_criteria() {
        CriteriaQuery<_Pizza> cr = cb.createQuery(_Pizza.class);
        Root<_Pizza> root = cr.from(_Pizza.class);
        cr.select(root);

        Query<_Pizza> query = session.createQuery(cr);
        List<_Pizza> results = query.getResultList();
    }
}
