package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Store<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: store,
     * db type: VARCHAR
     */
    default String getStore(){return getColumnParam("Store");}
    default E setStore(String val){setColumnParam("Store",val); return (E)this;}

    default Column<E,String,Store> colStore(){
        return new Column<E,String,Store>() {

            @Override
            public String getColumnName() {
                return "store";
            }

            @Override
            public String getFieldName() {
                return "Store";
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
            public String getColumnValue(Store entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Store");
                return  entity.getStore();
            }

            @Override
            public void setColumnValue(Store entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Store");
                entity.setStore(param);
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