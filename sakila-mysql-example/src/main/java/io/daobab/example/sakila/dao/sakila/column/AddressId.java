package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface AddressId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: address_id,
     * db type: SMALLINT
     */
    default Integer getAddressId(){return getColumnParam("AddressId");}
    default E setAddressId(Integer val){setColumnParam("AddressId",val); return (E)this;}

    default Column<E,Integer,AddressId> colAddressId(){
        return new Column<E,Integer,AddressId>() {

            @Override
            public String getColumnName() {
                return "address_id";
            }

            @Override
            public String getFieldName() {
                return "AddressId";
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
            public Integer getColumnValue(AddressId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"AddressId");
                return  entity.getAddressId();
            }

            @Override
            public void setColumnValue(AddressId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"AddressId");
                entity.setAddressId(param);
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