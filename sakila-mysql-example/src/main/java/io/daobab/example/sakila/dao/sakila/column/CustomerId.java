package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface CustomerId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: customer_id,
     * db type: SMALLINT
     */
    default Integer getCustomerId(){return getColumnParam("CustomerId");}
    default E setCustomerId(Integer val){setColumnParam("CustomerId",val); return (E)this;}

    default Column<E,Integer,CustomerId> colCustomerId(){
        return new Column<E,Integer,CustomerId>() {

            @Override
            public String getColumnName() {
                return "customer_id";
            }

            @Override
            public String getFieldName() {
                return "CustomerId";
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
            public Integer getColumnValue(CustomerId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"CustomerId");
                return  entity.getCustomerId();
            }

            @Override
            public void setColumnValue(CustomerId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"CustomerId");
                entity.setCustomerId(param);
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