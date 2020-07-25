package io.daobab.example.daobab_vs_jpa_criteria;

import io.daobab.Select;
import io.daobab.example.daobab_vs_jpa_criteria.base.TestBase;
import io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.table.Pizza;
import io.daobab.example.daobab_vs_jpa_criteria.jpa.entity._Pizza;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static io.daobab.statement.condition.Operator.GT;

public class GetById implements TestBase {


    @Override
    public void daobab() {
       Pizza results=Select.one(db,tabPizza).where(tabPizza.colPizzaId(),GT,toBigDecimal(10)).result();
    }

    @Override
    public void jpa_criteria() {
        CriteriaQuery<_Pizza> cr = cb.createQuery(_Pizza.class);
        Root<_Pizza> root = cr.from(_Pizza.class);
        cr.select(root);

        cr.where(cb.gt(root.get("pizzaId"), toBigDecimal(10)));

        Query<_Pizza> query = session.createQuery(cr);
        _Pizza results = query.getSingleResult();
    }
}
