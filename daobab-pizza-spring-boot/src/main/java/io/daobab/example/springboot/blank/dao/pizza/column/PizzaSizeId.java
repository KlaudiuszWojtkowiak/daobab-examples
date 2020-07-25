package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;

public interface PizzaSizeId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: pizza_size_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getPizzaSizeId(){return getColumnParam("pizzaSizeId");}
    default E setPizzaSizeId(BigDecimal val){setColumnParam("pizzaSizeId",val); return (E)this;}

    default Column<E, BigDecimal,PizzaSizeId> colPizzaSizeId(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "pizza_size_id";
            }

            @Override
            public String getFieldName() {
                return "pizzaSizeId";
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
            public BigDecimal getFieldValue(PizzaSizeId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"pizzaSizeId");
                return  entity.getPizzaSizeId();
            }

            @Override
            public void setFieldValue(PizzaSizeId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"pizzaSizeId");
                entity.setPizzaSizeId(param);
            }
        };
    }

}
