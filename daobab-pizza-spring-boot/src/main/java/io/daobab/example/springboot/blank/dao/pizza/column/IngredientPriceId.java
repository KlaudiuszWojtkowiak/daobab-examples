package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;

public interface IngredientPriceId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: ingredient_price_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getIngredientPriceId(){return getColumnParam("ingredientPriceId");}
    default E setIngredientPriceId(BigDecimal val){setColumnParam("ingredientPriceId",val); return (E)this;}

    default Column<E, BigDecimal,IngredientPriceId> colIngredientPriceId(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "ingredient_price_id";
            }

            @Override
            public String getFieldName() {
                return "ingredientPriceId";
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
            public BigDecimal getFieldValue(IngredientPriceId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"ingredientPriceId");
                return  entity.getIngredientPriceId();
            }

            @Override
            public void setFieldValue(IngredientPriceId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"ingredientPriceId");
                entity.setIngredientPriceId(param);
            }
        };
    }

}
