package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;

public interface PizzaPriceId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: pizza_price_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getPizzaPriceId(){return getColumnParam("pizzaPriceId");}
    default E setPizzaPriceId(BigDecimal val){setColumnParam("pizzaPriceId",val); return (E)this;}

    default Column<E, BigDecimal,PizzaPriceId> colPizzaPriceId(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "pizza_price_id";
            }

            @Override
            public String getFieldName() {
                return "pizzaPriceId";
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
            public BigDecimal getFieldValue(PizzaPriceId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"pizzaPriceId");
                return  entity.getPizzaPriceId();
            }

            @Override
            public void setFieldValue(PizzaPriceId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"pizzaPriceId");
                entity.setPizzaPriceId(param);
            }
        };
    }

}
