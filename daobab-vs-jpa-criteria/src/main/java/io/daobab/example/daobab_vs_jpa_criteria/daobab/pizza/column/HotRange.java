package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface HotRange<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: hot_range,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getHotRange(){return getColumnParam("hotRange");}
    default E setHotRange(BigDecimal val){setColumnParam("hotRange",val); return (E)this;}

    default Column<E,BigDecimal,HotRange> colHotRange(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "hot_range";
            }

            @Override
            public String getFieldName() {
                return "hotRange";
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
            public BigDecimal getColumnValue(HotRange entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"hotRange");
                return  entity.getHotRange();
            }

            @Override
            public void setColumnValue(HotRange entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"hotRange");
                entity.setHotRange(param);
            }
        };
    }

}
