package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.math.BigDecimal;

public interface RentalRate<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: rental_rate,
     * db type: DECIMAL
     */
    default BigDecimal getRentalRate(){return getColumnParam("RentalRate");}
    default E setRentalRate(BigDecimal val){setColumnParam("RentalRate",val); return (E)this;}

    default Column<E,BigDecimal,RentalRate> colRentalRate(){
        return new Column<E,BigDecimal,RentalRate>() {

            @Override
            public String getColumnName() {
                return "rental_rate";
            }

            @Override
            public String getFieldName() {
                return "RentalRate";
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
            public BigDecimal getColumnValue(RentalRate entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"RentalRate");
                return  entity.getRentalRate();
            }

            @Override
            public void setColumnValue(RentalRate entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"RentalRate");
                entity.setRentalRate(param);
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