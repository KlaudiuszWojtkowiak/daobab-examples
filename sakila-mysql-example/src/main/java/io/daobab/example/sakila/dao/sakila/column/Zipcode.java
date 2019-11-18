package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Zipcode<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: zip code,
     * db type: VARCHAR
     */
    default String getZipcode(){return getColumnParam("Zipcode");}
    default E setZipcode(String val){setColumnParam("Zipcode",val); return (E)this;}

    default Column<E,String,Zipcode> colZipcode(){
        return new Column<E,String,Zipcode>() {

            @Override
            public String getColumnName() {
                return "zip code";
            }

            @Override
            public String getFieldName() {
                return "Zipcode";
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
            public String getColumnValue(Zipcode entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Zipcode");
                return  entity.getZipcode();
            }

            @Override
            public void setColumnValue(Zipcode entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Zipcode");
                entity.setZipcode(param);
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