package io.daobab.example.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;

import java.sql.Timestamp;

public interface DeliverDate<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: deliver_date,<BR><BR>
     * db type: TIMESTAMP<BR><BR>
     */
    default Timestamp getDeliverDate(){return getColumnParam("deliverDate");}
    default E setDeliverDate(Timestamp val){setColumnParam("deliverDate",val); return (E)this;}

    default Column<E,Timestamp,DeliverDate> colDeliverDate(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "deliver_date";
            }

            @Override
            public String getFieldName() {
                return "deliverDate";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<Timestamp> getFieldClass(){
                return  Timestamp.class;
            }

            @Override
            public Timestamp getFieldValue(DeliverDate entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"deliverDate");
                return  entity.getDeliverDate();
            }

            @Override
            public void setFieldValue(DeliverDate entity, Timestamp param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"deliverDate");
                entity.setDeliverDate(param);
            }
        };
    }

}
