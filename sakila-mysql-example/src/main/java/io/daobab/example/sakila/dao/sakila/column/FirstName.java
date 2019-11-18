package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface FirstName<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: first_name,
     * db type: VARCHAR
     */
    default String getFirstName(){return getColumnParam("FirstName");}
    default E setFirstName(String val){setColumnParam("FirstName",val); return (E)this;}

    default Column<E,String,FirstName> colFirstName(){
        return new Column<E,String,FirstName>() {

            @Override
            public String getColumnName() {
                return "first_name";
            }

            @Override
            public String getFieldName() {
                return "FirstName";
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
            public String getColumnValue(FirstName entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"FirstName");
                return  entity.getFirstName();
            }

            @Override
            public void setColumnValue(FirstName entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"FirstName");
                entity.setFirstName(param);
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