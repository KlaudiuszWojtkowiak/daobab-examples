package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Manager<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: manager,
     * db type: VARCHAR
     */
    default String getManager(){return getColumnParam("Manager");}
    default E setManager(String val){setColumnParam("Manager",val); return (E)this;}

    default Column<E,String,Manager> colManager(){
        return new Column<E,String,Manager>() {

            @Override
            public String getColumnName() {
                return "manager";
            }

            @Override
            public String getFieldName() {
                return "Manager";
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
            public String getColumnValue(Manager entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Manager");
                return  entity.getManager();
            }

            @Override
            public void setColumnValue(Manager entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Manager");
                entity.setManager(param);
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