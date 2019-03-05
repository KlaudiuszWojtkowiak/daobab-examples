package io.daobab.example.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface Cm<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: cm,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getCm(){return getColumnParam("cm");}
    default E setCm(BigDecimal val){setColumnParam("cm",val); return (E)this;}

    default Column<E,BigDecimal,Cm> colCm(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "cm";
            }

            @Override
            public String getFieldName() {
                return "cm";
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
            public BigDecimal getColumnValue(Cm entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"cm");
                return  entity.getCm();
            }

            @Override
            public void setColumnValue(Cm entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"cm");
                entity.setCm(param);
            }
        };
    }

}
