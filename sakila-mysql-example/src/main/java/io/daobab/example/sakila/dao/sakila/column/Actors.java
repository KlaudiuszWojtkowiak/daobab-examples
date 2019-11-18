package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface Actors<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: actors,
     * db type: LONGVARCHAR
     */
    default String getActors(){return getColumnParam("Actors");}
    default E setActors(String val){setColumnParam("Actors",val); return (E)this;}

    default Column<E,String,Actors> colActors(){
        return new Column<E,String,Actors>() {

            @Override
            public String getColumnName() {
                return "actors";
            }

            @Override
            public String getFieldName() {
                return "Actors";
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
            public String getColumnValue(Actors entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Actors");
                return  entity.getActors();
            }

            @Override
            public void setColumnValue(Actors entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Actors");
                entity.setActors(param);
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