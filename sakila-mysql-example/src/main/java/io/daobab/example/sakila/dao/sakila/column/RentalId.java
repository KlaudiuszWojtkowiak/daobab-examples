package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.math.BigDecimal;

public interface RentalId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: rental_id,
     * db type: INTEGER
     */
    default BigDecimal getRentalId(){return getColumnParam("RentalId");}
    default E setRentalId(BigDecimal val){setColumnParam("RentalId",val); return (E)this;}

    default Column<E,BigDecimal,RentalId> colRentalId(){
        return new Column<E,BigDecimal,RentalId>() {

            @Override
            public String getColumnName() {
                return "rental_id";
            }

            @Override
            public String getFieldName() {
                return "RentalId";
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
            public BigDecimal getColumnValue(RentalId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"RentalId");
                return  entity.getRentalId();
            }

            @Override
            public void setColumnValue(RentalId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"RentalId");
                entity.setRentalId(param);
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