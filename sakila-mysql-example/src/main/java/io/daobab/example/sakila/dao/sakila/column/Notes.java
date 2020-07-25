package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Notes<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: notes,
     * db type: VARCHAR
     */
    default String getNotes(){return getColumnParam("Notes");}
    default E setNotes(String val){setColumnParam("Notes",val); return (E)this;}

    default Column<E,String,Notes> colNotes(){
        return new Column<E,String,Notes>() {

            @Override
            public String getColumnName() {
                return "notes";
            }

            @Override
            public String getFieldName() {
                return "Notes";
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
            public String getFieldValue(Notes entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Notes");
                return  entity.getNotes();
            }

            @Override
            public void setFieldValue(Notes entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Notes");
                entity.setNotes(param);
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