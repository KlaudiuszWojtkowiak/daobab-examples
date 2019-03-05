package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface PizzaIngredientId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: pizza_ingredient_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getPizzaIngredientId(){return getColumnParam("pizzaIngredientId");}
    default E setPizzaIngredientId(BigDecimal val){setColumnParam("pizzaIngredientId",val); return (E)this;}

    default Column<E,BigDecimal,PizzaIngredientId> colPizzaIngredientId(){
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
            public Class<BigDecimal> getColumnClass(){
                return  BigDecimal.class;
            }

            @Override
            public BigDecimal getColumnValue(PizzaIngredientId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"pizzaIngredientId");
                return  entity.getPizzaIngredientId();
            }

            @Override
            public void setColumnValue(PizzaIngredientId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"pizzaIngredientId");
                entity.setPizzaIngredientId(param);
            }
        };
    }

}