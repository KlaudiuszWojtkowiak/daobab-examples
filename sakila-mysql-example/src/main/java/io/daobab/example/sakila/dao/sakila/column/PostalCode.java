package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface PostalCode<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: postal_code,
     * db type: VARCHAR
     */
    default String getPostalCode(){return getColumnParam("PostalCode");}
    default E setPostalCode(String val){setColumnParam("PostalCode",val); return (E)this;}

    default Column<E,String,PostalCode> colPostalCode(){
        return new Column<E,String,PostalCode>() {

            @Override
            public String getColumnName() {
                return "postal_code";
            }

            @Override
            public String getFieldName() {
                return "PostalCode";
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
            public String getColumnValue(PostalCode entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"PostalCode");
                return  entity.getPostalCode();
            }

            @Override
            public void setColumnValue(PostalCode entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"PostalCode");
                entity.setPostalCode(param);
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