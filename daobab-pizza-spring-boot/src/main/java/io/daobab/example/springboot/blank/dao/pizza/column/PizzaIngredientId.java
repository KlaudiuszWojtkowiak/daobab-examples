package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;

public interface PizzaIngredientId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: pizza_ingredient_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getPizzaIngredientId(){return getColumnParam("pizzaIngredientId");}
    default E setPizzaIngredientId(BigDecimal val){setColumnParam("pizzaIngredientId",val); return (E)this;}

    default Column<E, BigDecimal,PizzaIngredientId> colPizzaIngredientId(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "pizza_ingredient_id";
            }

            @Override
            public String getFieldName() {
                return "pizzaIngredientId";
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
            public BigDecimal getFieldValue(PizzaIngredientId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"pizzaIngredientId");
                return  entity.getPizzaIngredientId();
            }

            @Override
            public void setFieldValue(PizzaIngredientId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"pizzaIngredientId");
                entity.setPizzaIngredientId(param);
            }
        };
    }

}
