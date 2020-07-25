package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Rating<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: rating,
     * db type: CHAR
     */
    default String getRating(){return getColumnParam("Rating");}
    default E setRating(String val){setColumnParam("Rating",val); return (E)this;}

    default Column<E,String,Rating> colRating(){
        return new Column<E,String,Rating>() {

            @Override
            public String getColumnName() {
                return "rating";
            }

            @Override
            public String getFieldName() {
                return "Rating";
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
            public String getFieldValue(Rating entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Rating");
                return  entity.getRating();
            }

            @Override
            public void setFieldValue(Rating entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Rating");
                entity.setRating(param);
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