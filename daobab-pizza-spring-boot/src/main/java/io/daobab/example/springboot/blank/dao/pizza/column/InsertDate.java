package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.sql.Timestamp;

public interface InsertDate<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: insert_date,<BR><BR>
     * db type: TIMESTAMP<BR><BR>
     */
    default Timestamp getInsertDate(){return getColumnParam("insertDate");}
    default E setInsertDate(Timestamp val){setColumnParam("insertDate",val); return (E)this;}

    default Column<E, Timestamp,InsertDate> colInsertDate(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "insert_date";
            }

            @Override
            public String getFieldName() {
                return "insertDate";
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
            public Timestamp getFieldValue(InsertDate entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"insertDate");
                return  entity.getInsertDate();
            }

            @Override
            public void setFieldValue(InsertDate entity, Timestamp param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"insertDate");
                entity.setInsertDate(param);
            }
        };
    }

}
