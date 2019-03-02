package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface IngredientId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: ingredient_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getIngredientId(){return getColumnParam("ingredientId");}
    default E setIngredientId(BigDecimal val){setColumnParam("ingredientId",val); return (E)this;}

    default Column<E,BigDecimal,IngredientId> colIngredientId(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "ingredient_id";
            }

            @Override
            public String getFieldName() {
                return "ingredientId";
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
            public BigDecimal getColumnValue(IngredientId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"ingredientId");
                return  entity.getIngredientId();
            }

            @Override
            public void setColumnValue(IngredientId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"ingredientId");
                entity.setIngredientId(param);
            }
        };
    }

}