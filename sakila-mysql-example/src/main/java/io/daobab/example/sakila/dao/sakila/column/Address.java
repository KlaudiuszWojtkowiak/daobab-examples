package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Address<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: address,
     * db type: VARCHAR
     */
    default String getAddress(){return getColumnParam("Address");}
    default E setAddress(String val){setColumnParam("Address",val); return (E)this;}

    default Column<E,String,Address> colAddress(){
        return new Column<E,String,Address>() {

            @Override
            public String getColumnName() {
                return "address";
            }

            @Override
            public String getFieldName() {
                return "Address";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<String> getColumnClass(){
                return  String.class;
            }

            @Override
            public String getColumnValue(Address entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Address");
                return  entity.getAddress();
            }

            @Override
            public void setColumnValue(Address entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Address");
                entity.setAddress(param);
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