package io.daobab.example.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface OrderAdditionalId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: order_additional_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getOrderAdditionalId(){return getColumnParam("orderAdditionalId");}
    default E setOrderAdditionalId(BigDecimal val){setColumnParam("orderAdditionalId",val); return (E)this;}

    default Column<E,BigDecimal,OrderAdditionalId> colOrderAdditionalId(){
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
            public Class<BigDecimal> getColumnClass(){
                return  BigDecimal.class;
            }

            @Override
            public BigDecimal getColumnValue(OrderAdditionalId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"orderAdditionalId");
                return  entity.getOrderAdditionalId();
            }

            @Override
            public void setColumnValue(OrderAdditionalId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"orderAdditionalId");
                entity.setOrderAdditionalId(param);
            }
        };
    }

}
