package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface PizzaId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: pizza_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getPizzaId(){return getColumnParam("pizzaId");}
    default E setPizzaId(BigDecimal val){setColumnParam("pizzaId",val); return (E)this;}

    default Column<E,BigDecimal,PizzaId> colPizzaId(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "pizza_id";
            }

            @Override
            public String getFieldName() {
                return "pizzaId";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<BigDecimal> getFieldClass(){
                return  BigDecimal.class;
            }

            @Override
            public BigDecimal getFieldValue(PizzaId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"pizzaId");
                return  entity.getPizzaId();
            }

            @Override
            public void setFieldValue(PizzaId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"pizzaId");
                entity.setPizzaId(param);
            }
        };
    }

}
