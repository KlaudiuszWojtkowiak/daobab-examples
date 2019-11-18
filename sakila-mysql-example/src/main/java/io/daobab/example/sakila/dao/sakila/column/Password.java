package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Password<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: password,
     * db type: VARCHAR
     */
    default String getPassword(){return getColumnParam("Password");}
    default E setPassword(String val){setColumnParam("Password",val); return (E)this;}

    default Column<E,String,Password> colPassword(){
        return new Column<E,String,Password>() {

            @Override
            public String getColumnName() {
                return "password";
            }

            @Override
            public String getFieldName() {
                return "Password";
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
            public String getColumnValue(Password entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Password");
                return  entity.getPassword();
            }

            @Override
            public void setColumnValue(Password entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Password");
                entity.setPassword(param);
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