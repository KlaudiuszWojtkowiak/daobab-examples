package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Description<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: description,
     * db type: LONGVARCHAR
     */
    default String getDescription(){return getColumnParam("Description");}
    default E setDescription(String val){setColumnParam("Description",val); return (E)this;}

    default Column<E,String,Description> colDescription(){
        return new Column<E,String,Description>() {

            @Override
            public String getColumnName() {
                return "description";
            }

            @Override
            public String getFieldName() {
                return "Description";
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
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Description");
                return  entity.getDescription();
            }

            @Override
            public void setColumnValue(Description entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Description");
                entity.setDescription(param);
            }

            @Override
            public int hashCode() {
                return toString().hashCode();
            }

            @Override
            public String toString(){
                return getEntityName()+"."+getFieldName();
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)return true;
                if (obj == null)return false;
                if (getClass() != obj.getClass())return false;
                Column other = (Column) obj;
                return Objects.equals(hashCode(), other.hashCode());
            }        };
    }

}