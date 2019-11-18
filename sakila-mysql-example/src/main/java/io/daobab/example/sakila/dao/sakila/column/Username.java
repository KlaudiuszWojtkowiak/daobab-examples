package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Username<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: username,
     * db type: VARCHAR
     */
    default String getUsername(){return getColumnParam("Username");}
    default E setUsername(String val){setColumnParam("Username",val); return (E)this;}

    default Column<E,String,Username> colUsername(){
        return new Column<E,String,Username>() {

            @Override
            public String getColumnName() {
                return "username";
            }

            @Override
            public String getFieldName() {
                return "Username";
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
            public String getColumnValue(Username entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Username");
                return  entity.getUsername();
            }

            @Override
            public void setColumnValue(Username entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Username");
                entity.setUsername(param);
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