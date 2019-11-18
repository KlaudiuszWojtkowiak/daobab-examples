package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Email<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: email,
     * db type: VARCHAR
     */
    default String getEmail(){return getColumnParam("Email");}
    default E setEmail(String val){setColumnParam("Email",val); return (E)this;}

    default Column<E,String,Email> colEmail(){
        return new Column<E,String,Email>() {

            @Override
            public String getColumnName() {
                return "email";
            }

            @Override
            public String getFieldName() {
                return "Email";
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
            public String getColumnValue(Email entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Email");
                return  entity.getEmail();
            }

            @Override
            public void setColumnValue(Email entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Email");
                entity.setEmail(param);
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