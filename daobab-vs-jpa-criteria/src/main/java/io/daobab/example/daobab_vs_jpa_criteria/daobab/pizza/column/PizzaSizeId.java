package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface PizzaSizeId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: pizza_size_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getPizzaSizeId(){return getColumnParam("pizzaSizeId");}
    default E setPizzaSizeId(BigDecimal val){setColumnParam("pizzaSizeId",val); return (E)this;}

    default Column<E,BigDecimal,PizzaSizeId> colPizzaSizeId(){
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
            public Class<BigDecimal> getColumnClass(){
                return  BigDecimal.class;
            }

            @Override
            public BigDecimal getColumnValue(PizzaSizeId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"pizzaSizeId");
                return  entity.getPizzaSizeId();
            }

            @Override
            public void setColumnValue(PizzaSizeId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"pizzaSizeId");
                entity.setPizzaSizeId(param);
            }
        };
    }

}
