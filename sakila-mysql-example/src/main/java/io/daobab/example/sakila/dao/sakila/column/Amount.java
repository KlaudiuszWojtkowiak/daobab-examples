package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.math.BigDecimal;

public interface Amount<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: amount,
     * db type: DECIMAL
     */
    default BigDecimal getAmount(){return getColumnParam("Amount");}
    default E setAmount(BigDecimal val){setColumnParam("Amount",val); return (E)this;}

    default Column<E,BigDecimal,Amount> colAmount(){
        return new Column<E,BigDecimal,Amount>() {

            @Override
            public String getColumnName() {
                return "amount";
            }

            @Override
            public String getFieldName() {
                return "Amount";
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
            public BigDecimal getFieldValue(Amount entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Amount");
                return  entity.getAmount();
            }

            @Override
            public void setFieldValue(Amount entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Amount");
                entity.setAmount(param);
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