package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface Price<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: price,<BR><BR>
     * db type: DOUBLE<BR><BR>
     */
    default BigDecimal getPrice(){return getColumnParam("price");}
    default E setPrice(BigDecimal val){setColumnParam("price",val); return (E)this;}

    default Column<E,BigDecimal,Price> colPrice(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "price";
            }

            @Override
            public String getFieldName() {
                return "price";
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
            public BigDecimal getColumnValue(Price entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"price");
                return  entity.getPrice();
            }

            @Override
            public void setColumnValue(Price entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"price");
                entity.setPrice(param);
            }
        };
    }

}