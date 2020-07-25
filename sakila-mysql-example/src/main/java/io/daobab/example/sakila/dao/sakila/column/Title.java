package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Title<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: title,
     * db type: VARCHAR
     */
    default String getTitle(){return getColumnParam("Title");}
    default E setTitle(String val){setColumnParam("Title",val); return (E)this;}

    default Column<E,String,Title> colTitle(){
        return new Column<E,String,Title>() {

            @Override
            public String getColumnName() {
                return "title";
            }

            @Override
            public String getFieldName() {
                return "Title";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<String> getFieldClass(){
                return  String.class;
            }

            @Override
            public String getFieldValue(Title entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Title");
                return  entity.getTitle();
            }

            @Override
            public void setFieldValue(Title entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Title");
                entity.setTitle(param);
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