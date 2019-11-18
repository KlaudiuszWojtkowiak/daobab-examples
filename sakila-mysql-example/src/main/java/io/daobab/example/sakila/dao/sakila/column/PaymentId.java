package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface PaymentId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: payment_id,
     * db type: SMALLINT
     */
    default Integer getPaymentId(){return getColumnParam("PaymentId");}
    default E setPaymentId(Integer val){setColumnParam("PaymentId",val); return (E)this;}

    default Column<E,Integer,PaymentId> colPaymentId(){
        return new Column<E,Integer,PaymentId>() {

            @Override
            public String getColumnName() {
                return "payment_id";
            }

            @Override
            public String getFieldName() {
                return "PaymentId";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<Integer> getColumnClass(){
                return  Integer.class;
            }

            @Override
            public Integer getColumnValue(PaymentId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"PaymentId");
                return  entity.getPaymentId();
            }

            @Override
            public void setColumnValue(PaymentId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"PaymentId");
                entity.setPaymentId(param);
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