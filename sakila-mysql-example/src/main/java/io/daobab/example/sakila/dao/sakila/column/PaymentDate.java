package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.sql.Timestamp;

public interface PaymentDate<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: payment_date,
     * db type: TIMESTAMP
     */
    default Timestamp getPaymentDate(){return getColumnParam("PaymentDate");}
    default E setPaymentDate(Timestamp val){setColumnParam("PaymentDate",val); return (E)this;}

    default Column<E,Timestamp,PaymentDate> colPaymentDate(){
        return new Column<E,Timestamp,PaymentDate>() {

            @Override
            public String getColumnName() {
                return "payment_date";
            }

            @Override
            public String getFieldName() {
                return "PaymentDate";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<Timestamp> getColumnClass(){
                return  Timestamp.class;
            }

            @Override
            public Timestamp getColumnValue(PaymentDate entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"PaymentDate");
                return  entity.getPaymentDate();
            }

            @Override
            public void setColumnValue(PaymentDate entity, Timestamp param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"PaymentDate");
                entity.setPaymentDate(param);
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