package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.math.BigDecimal;

public interface ReplacementCost<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: replacement_cost,
     * db type: DECIMAL
     */
    default BigDecimal getReplacementCost(){return getColumnParam("ReplacementCost");}
    default E setReplacementCost(BigDecimal val){setColumnParam("ReplacementCost",val); return (E)this;}

    default Column<E,BigDecimal,ReplacementCost> colReplacementCost(){
        return new Column<E,BigDecimal,ReplacementCost>() {

            @Override
            public String getColumnName() {
                return "replacement_cost";
            }

            @Override
            public String getFieldName() {
                return "ReplacementCost";
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
            public BigDecimal getColumnValue(ReplacementCost entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"ReplacementCost");
                return  entity.getReplacementCost();
            }

            @Override
            public void setColumnValue(ReplacementCost entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"ReplacementCost");
                entity.setReplacementCost(param);
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