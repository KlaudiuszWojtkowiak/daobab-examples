package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface Cm<E extends EntityMap> extends EntityRelationMap<E> {


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
            public Class<BigDecimal> getFieldClass(){
                return  BigDecimal.class;
            }

            @Override
            public BigDecimal getFieldValue(Cm entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"cm");
                return  entity.getCm();
            }

            @Override
            public void setFieldValue(Cm entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"cm");
                entity.setCm(param);
            }
        };
    }

}
