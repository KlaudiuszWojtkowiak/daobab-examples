package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;

public interface OrderAdditionalId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: order_additional_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getOrderAdditionalId(){return getColumnParam("orderAdditionalId");}
    default E setOrderAdditionalId(BigDecimal val){setColumnParam("orderAdditionalId",val); return (E)this;}

    default Column<E, BigDecimal,OrderAdditionalId> colOrderAdditionalId(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "order_additional_id";
            }

            @Override
            public String getFieldName() {
                return "orderAdditionalId";
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
            public BigDecimal getFieldValue(OrderAdditionalId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"orderAdditionalId");
                return  entity.getOrderAdditionalId();
            }

            @Override
            public void setFieldValue(OrderAdditionalId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"orderAdditionalId");
                entity.setOrderAdditionalId(param);
            }
        };
    }

}
