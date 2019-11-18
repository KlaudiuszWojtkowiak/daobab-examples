package io.daobab.example.pizza.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;

public interface Adress<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: adress,<BR><BR>
     * db type: VARCHAR<BR><BR>
     */
    default String getAdress(){return getColumnParam("adress");}
    default E setAdress(String val){setColumnParam("adress",val); return (E)this;}

    default Column<E,String,Adress> colAdress(){
        return new Column<>() {

            @Override
            public String getColumnName() {
                return "adress";
            }

            @Override
            public String getFieldName() {
                return "adress";
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
            public String getColumnValue(Adress entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"adress");
                return  entity.getAdress();
            }

            @Override
            public void setColumnValue(Adress entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"adress");
                entity.setAdress(param);
            }
        };
    }

}