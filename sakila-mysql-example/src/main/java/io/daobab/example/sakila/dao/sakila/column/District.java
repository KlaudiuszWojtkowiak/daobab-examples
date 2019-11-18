package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface District<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: district,
     * db type: VARCHAR
     */
    default String getDistrict(){return getColumnParam("District");}
    default E setDistrict(String val){setColumnParam("District",val); return (E)this;}

    default Column<E,String,District> colDistrict(){
        return new Column<E,String,District>() {

            @Override
            public String getColumnName() {
                return "district";
            }

            @Override
            public String getFieldName() {
                return "District";
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
            public String getColumnValue(District entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"District");
                return  entity.getDistrict();
            }

            @Override
            public void setColumnValue(District entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"District");
                entity.setDistrict(param);
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