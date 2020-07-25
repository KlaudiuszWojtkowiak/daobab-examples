package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface LastName<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: last_name,
     * db type: VARCHAR
     */
    default String getLastName(){return getColumnParam("LastName");}
    default E setLastName(String val){setColumnParam("LastName",val); return (E)this;}

    default Column<E,String,LastName> colLastName(){
        return new Column<E,String,LastName>() {

            @Override
            public String getColumnName() {
                return "last_name";
            }

            @Override
            public String getFieldName() {
                return "LastName";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<String> getFieldClass(){
                return  String.class;
            }

            @Override
            public String getFieldValue(LastName entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"LastName");
                return  entity.getLastName();
            }

            @Override
            public void setFieldValue(LastName entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"LastName");
                entity.setLastName(param);
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