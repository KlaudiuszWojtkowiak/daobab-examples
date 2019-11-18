package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.math.BigDecimal;

public interface TotalSales<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: total_sales,
     * db type: DECIMAL
     */
    default BigDecimal getTotalSales(){return getColumnParam("TotalSales");}
    default E setTotalSales(BigDecimal val){setColumnParam("TotalSales",val); return (E)this;}

    default Column<E,BigDecimal,TotalSales> colTotalSales(){
        return new Column<E,BigDecimal,TotalSales>() {

            @Override
            public String getColumnName() {
                return "total_sales";
            }

            @Override
            public String getFieldName() {
                return "TotalSales";
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
            public BigDecimal getColumnValue(TotalSales entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"TotalSales");
                return  entity.getTotalSales();
            }

            @Override
            public void setColumnValue(TotalSales entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"TotalSales");
                entity.setTotalSales(param);
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