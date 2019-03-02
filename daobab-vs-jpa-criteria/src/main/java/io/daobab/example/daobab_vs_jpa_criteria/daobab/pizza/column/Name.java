package io.daobab.example.daobab_vs_jpa_criteria.daobab.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

import java.lang.String;

public interface Name<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: name,<BR><BR>
     * db type: VARCHAR<BR><BR>
     */
    default String getName(){return getColumnParam("name");}
    default E setName(String val){setColumnParam("name",val); return (E)this;}

    default Column<E,String,Name> colName(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "name";
            }

            @Override
            public String getFieldName() {
                return "name";
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
            public String getColumnValue(Name entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"name");
                return  entity.getName();
            }

            @Override
            public void setColumnValue(Name entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"name");
                entity.setName(param);
            }
        };
    }

}
