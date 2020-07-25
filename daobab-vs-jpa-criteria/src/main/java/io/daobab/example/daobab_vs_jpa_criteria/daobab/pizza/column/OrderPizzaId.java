package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface OrderPizzaId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: order_pizza_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getOrderPizzaId(){return getColumnParam("orderPizzaId");}
    default E setOrderPizzaId(BigDecimal val){setColumnParam("orderPizzaId",val); return (E)this;}

    default Column<E,BigDecimal,OrderPizzaId> colOrderPizzaId(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "order_pizza_id";
            }

            @Override
            public String getFieldName() {
                return "orderPizzaId";
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
            public BigDecimal getFieldValue(OrderPizzaId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"orderPizzaId");
                return  entity.getOrderPizzaId();
            }

            @Override
            public void setFieldValue(OrderPizzaId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"orderPizzaId");
                entity.setOrderPizzaId(param);
            }
        };
    }

}
