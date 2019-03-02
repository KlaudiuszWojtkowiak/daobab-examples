package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.sql.Timestamp;

public interface InsertDate<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: insert_date,<BR><BR>
     * db type: TIMESTAMP<BR><BR>
     */
    default Timestamp getInsertDate(){return getColumnParam("insertDate");}
    default E setInsertDate(Timestamp val){setColumnParam("insertDate",val); return (E)this;}

    default Column<E,Timestamp,InsertDate> colInsertDate(){
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
            public Class<Timestamp> getColumnClass(){
                return  Timestamp.class;
            }

            @Override
            public Timestamp getColumnValue(InsertDate entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"insertDate");
                return  entity.getInsertDate();
            }

            @Override
            public void setColumnValue(InsertDate entity, Timestamp param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"insertDate");
                entity.setInsertDate(param);
            }
        };
    }

}
