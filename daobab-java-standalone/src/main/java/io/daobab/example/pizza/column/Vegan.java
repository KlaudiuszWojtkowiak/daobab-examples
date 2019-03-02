package io.daobab.example.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface Vegan<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: vegan,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getVegan(){return getColumnParam("vegan");}
    default E setVegan(BigDecimal val){setColumnParam("vegan",val); return (E)this;}

    default Column<E,BigDecimal,Vegan> colVegan(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "vegan";
            }

            @Override
            public String getFieldName() {
                return "vegan";
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
            public BigDecimal getColumnValue(Vegan entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"vegan");
                return  entity.getVegan();
            }

            @Override
            public void setColumnValue(Vegan entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"vegan");
                entity.setVegan(param);
            }
        };
    }

}
