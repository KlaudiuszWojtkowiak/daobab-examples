package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;

public interface Vegetarian<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: vegetarian,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getVegetarian(){return getColumnParam("vegetarian");}
    default E setVegetarian(BigDecimal val){setColumnParam("vegetarian",val); return (E)this;}

    default Column<E, BigDecimal,Vegetarian> colVegetarian(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "vegetarian";
            }

            @Override
            public String getFieldName() {
                return "vegetarian";
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
            public BigDecimal getFieldValue(Vegetarian entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"vegetarian");
                return  entity.getVegetarian();
            }

            @Override
            public void setFieldValue(Vegetarian entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"vegetarian");
                entity.setVegetarian(param);
            }
        };
    }

}
