package io.daobab.example.springboot.blank.dao.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.lang.String;

public interface Description<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: description,<BR><BR>
     * db type: VARCHAR<BR><BR>
     */
    default String getDescription(){return getColumnParam("description");}
    default E setDescription(String val){setColumnParam("description",val); return (E)this;}

    default Column<E,String,Description> colDescription(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "description";
            }

            @Override
            public String getFieldName() {
                return "description";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<String> getColumnClass(){
                return  String.class;
            }

            @Override
            public String getColumnValue(Description entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"description");
                return  entity.getDescription();
            }

            @Override
            public void setColumnValue(Description entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"description");
                entity.setDescription(param);
            }
        };
    }

}