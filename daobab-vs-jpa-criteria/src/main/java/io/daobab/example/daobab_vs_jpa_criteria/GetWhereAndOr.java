package io.daobab.example.daobab_vs_jpa_criteria;

import io.daobab.Select;
import io.daobab.example.daobab_vs_jpa_criteria.base.TestBase;
import io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.table.Pizza;
import io.daobab.example.daobab_vs_jpa_criteria.jpa.entity._Pizza;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;

import static io.daobab.statement.condition.Operator.*;
import static io.daobab.statement.where.base.Where.AND;
import static io.daobab.statement.where.base.Where.OR;

public class GetWhereAndOr implements TestBase {


    @Override
    public void daobab() {
       List<Pizza> results=Select.many(db,tabPizza)
           .where(AND()
               .and(OR()
                   .or(tabPizza.colName(),LIKE,"%A%")
                   .or(tabPizza.colName(),LIKE,"%B%"))
               .and(OR()
                   .or(tabPizza.colID(),LT,toBD(10))
                    .or(tabPizza.colID(),GT,toBD(20))))
           .result();
    }

    @Override
    public void jpa_criteria() {
        CriteriaQuery<_Pizza> cr = cb.createQuery(_Pizza.class);
        Root<_Pizza> root = cr.from(_Pizza.class);

        Predicate or1=cb.or(
            cb.like(root.get("name"),"%A%"),
            cb.like(root.get("name"),"%B%")
        );

        Predicate or2=cb.or(
            cb.lt(root.get("pizzaId"),toBD(10)),
            cb.gt(root.get("pizzaId"),toBD(20))
        );

        Predicate andClause=cb.and(or1,or2);

        cr.select(root).where(andClause);

        Query<_Pizza> query = session.createQuery(cr);
        List<_Pizza> results = query.getResultList();
    }
}
