package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.math.BigDecimal;

public interface Price<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: price,
     * db type: DECIMAL
     */
    default BigDecimal getPrice(){return getColumnParam("Price");}
    default E setPrice(BigDecimal val){setColumnParam("Price",val); return (E)this;}

    default Column<E,BigDecimal,Price> colPrice(){
        return new Column<E,BigDecimal,Price>() {

            @Override
            public String getColumnName() {
                return "price";
            }

            @Override
            public String getFieldName() {
                return "Price";
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
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Price");
                return  entity.getPrice();
            }

            @Override
            public void setColumnValue(Price entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Price");
                entity.setPrice(param);
            }

            @Override
            public int hashCode() {
                return toString().hashCode();
            }

            @Override
            public String toString(){
                return getEntityName()+"."+getFieldName();
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)return true;
                if (obj == null)return false;
                if (getClass() != obj.getClass())return false;
                Column other = (Column) obj;
                return Objects.equals(hashCode(), other.hashCode());
            }        };
    }

}