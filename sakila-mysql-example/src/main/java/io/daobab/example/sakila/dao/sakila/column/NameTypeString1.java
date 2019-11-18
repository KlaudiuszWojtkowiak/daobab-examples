package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface NameTypeString1<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: name,
     * db type: VARCHAR
     */
    default String getNameTypeString1(){return getColumnParam("NameTypeString1");}
    default E setNameTypeString1(String val){setColumnParam("NameTypeString1",val); return (E)this;}

    default Column<E,String,NameTypeString1> colNameTypeString1(){
        return new Column<E,String,NameTypeString1>() {

            @Override
            public String getColumnName() {
                return "name";
            }

            @Override
            public String getFieldName() {
                return "NameTypeString1";
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
            public String getColumnValue(NameTypeString1 entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"NameTypeString1");
                return  entity.getNameTypeString1();
            }

            @Override
            public void setColumnValue(NameTypeString1 entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"NameTypeString1");
                entity.setNameTypeString1(param);
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