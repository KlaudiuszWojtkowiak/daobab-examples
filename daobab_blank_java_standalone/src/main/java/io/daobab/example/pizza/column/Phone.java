package io.daobab.example.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

public interface Phone<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: phone,<BR><BR>
     * db type: VARCHAR<BR><BR>
     */
    default String getPhone(){return getColumnParam("phone");}
    default E setPhone(String val){setColumnParam("phone",val); return (E)this;}

    default Column<E,String,Phone> colPhone(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "phone";
            }

            @Override
            public String getFieldName() {
                return "phone";
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
            public String getColumnValue(Phone entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"phone");
                return  entity.getPhone();
            }

            @Override
            public void setColumnValue(Phone entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"phone");
                entity.setPhone(param);
            }
        };
    }

}
