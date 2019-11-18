package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface City<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: city,
     * db type: VARCHAR
     */
    default String getCity(){return getColumnParam("City");}
    default E setCity(String val){setColumnParam("City",val); return (E)this;}

    default Column<E,String,City> colCity(){
        return new Column<E,String,City>() {

            @Override
            public String getColumnName() {
                return "city";
            }

            @Override
            public String getFieldName() {
                return "City";
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
            public String getColumnValue(City entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"City");
                return  entity.getCity();
            }

            @Override
            public void setColumnValue(City entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"City");
                entity.setCity(param);
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