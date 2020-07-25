package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;

import java.math.BigDecimal;

public interface CustomerId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: customer_id,<BR><BR>
     * db type: INTEGER<BR><BR>
     */
    default BigDecimal getCustomerId(){return getColumnParam("customerId");}
    default E setCustomerId(BigDecimal val){setColumnParam("customerId",val); return (E)this;}

    default Column<E,BigDecimal,CustomerId> colCustomerId(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "customer_id";
            }

            @Override
            public String getFieldName() {
                return "customerId";
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
            public BigDecimal getFieldValue(CustomerId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"customerId");
                return  entity.getCustomerId();
            }

            @Override
            public void setFieldValue(CustomerId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"customerId");
                entity.setCustomerId(param);
            }
        };
    }

}
