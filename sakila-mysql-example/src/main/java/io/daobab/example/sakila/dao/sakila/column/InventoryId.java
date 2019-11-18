package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.math.BigDecimal;

public interface InventoryId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: inventory_id,
     * db type: INTEGER
     */
    default BigDecimal getInventoryId(){return getColumnParam("InventoryId");}
    default E setInventoryId(BigDecimal val){setColumnParam("InventoryId",val); return (E)this;}

    default Column<E,BigDecimal,InventoryId> colInventoryId(){
        return new Column<E,BigDecimal,InventoryId>() {

            @Override
            public String getColumnName() {
                return "inventory_id";
            }

            @Override
            public String getFieldName() {
                return "InventoryId";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<BigDecimal> getColumnClass(){
                return  BigDecimal.class;
            }

            @Override
            public BigDecimal getColumnValue(InventoryId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"InventoryId");
                return  entity.getInventoryId();
            }

            @Override
            public void setColumnValue(InventoryId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"InventoryId");
                entity.setInventoryId(param);
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