package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Country<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: country,
     * db type: VARCHAR
     */
    default String getCountry(){return getColumnParam("Country");}
    default E setCountry(String val){setColumnParam("Country",val); return (E)this;}

    default Column<E,String,Country> colCountry(){
        return new Column<E,String,Country>() {

            @Override
            public String getColumnName() {
                return "country";
            }

            @Override
            public String getFieldName() {
                return "Country";
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
            public String getColumnValue(Country entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Country");
                return  entity.getCountry();
            }

            @Override
            public void setColumnValue(Country entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Country");
                entity.setCountry(param);
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