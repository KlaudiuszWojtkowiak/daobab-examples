package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface StoreId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: store_id,
     * db type: TINYINT
     */
    default Integer getStoreId(){return getColumnParam("StoreId");}
    default E setStoreId(Integer val){setColumnParam("StoreId",val); return (E)this;}

    default Column<E,Integer,StoreId> colStoreId(){
        return new Column<E,Integer,StoreId>() {

            @Override
            public String getColumnName() {
                return "store_id";
            }

            @Override
            public String getFieldName() {
                return "StoreId";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<Integer> getColumnClass(){
                return  Integer.class;
            }

            @Override
            public Integer getColumnValue(StoreId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"StoreId");
                return  entity.getStoreId();
            }

            @Override
            public void setColumnValue(StoreId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"StoreId");
                entity.setStoreId(param);
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