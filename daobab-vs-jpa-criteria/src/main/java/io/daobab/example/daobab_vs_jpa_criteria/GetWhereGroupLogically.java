package io.daobab.example.daobab_vs_jpa_criteria;

import io.daobab.Select;
import io.daobab.example.daobab_vs_jpa_criteria.base.TestBase;
import io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.table.Pizza;
import io.daobab.example.daobab_vs_jpa_criteria.jpa.entity._Pizza;
import org.hibernate.Criteria;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static io.daobab.statement.condition.Operator.*;
import static io.daobab.statement.where.base.Where.AND;
import static io.daobab.statement.where.base.Where.OR;

public class GetWhereGroupLogically implements TestBase {


    @Override
    public void daobab() {
        List<Pizza> results=Select.many(db,tabPizza)
            .where(AND()
                .and(tabPizza.colDescription(),NOT_NULL)
                .and(AND()
                    .and(tabPizza.colName(),LIKE,"%A%")
                    .and(tabPizza.colID(),GT,toBD(20))))
            .result();
    }

    @Override
    public void jpa_criteria() {
        CriteriaQuery<_Pizza> cr = cb.createQuery(_Pizza.class);
        Root<_Pizza> root = cr.from(_Pizza.class);


        Predicate and1=cb.or(
            cb.isNotNull(root.get("description"))
        );

        Predicate and2=cb.or(
            cb.like(root.get("name"),"%A%"),
            cb.lt(root.get("pizzaId"),toBD(10))
        );

        Predicate and=cb.and(and1,and2);

        cr.select(root).where(and);

        Query<_Pizza> query = session.createQuery(cr);
        List<_Pizza> results = query.getResultList();
    }
}
