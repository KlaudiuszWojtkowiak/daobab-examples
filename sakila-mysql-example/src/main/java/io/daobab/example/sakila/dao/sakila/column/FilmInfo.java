package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface FilmInfo<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: film_info,
     * db type: LONGVARCHAR
     */
    default String getFilmInfo(){return getColumnParam("FilmInfo");}
    default E setFilmInfo(String val){setColumnParam("FilmInfo",val); return (E)this;}

    default Column<E,String,FilmInfo> colFilmInfo(){
        return new Column<E,String,FilmInfo>() {

            @Override
            public String getColumnName() {
                return "film_info";
            }

            @Override
            public String getFieldName() {
                return "FilmInfo";
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
            public String getFieldValue(FilmInfo entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"FilmInfo");
                return  entity.getFilmInfo();
            }

            @Override
            public void setFieldValue(FilmInfo entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"FilmInfo");
                entity.setFilmInfo(param);
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