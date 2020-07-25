package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface LanguageId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: language_id,
     * db type: TINYINT
     */
    default Integer getLanguageId(){return getColumnParam("LanguageId");}
    default E setLanguageId(Integer val){setColumnParam("LanguageId",val); return (E)this;}

    default Column<E,Integer,LanguageId> colLanguageId(){
        return new Column<E,Integer,LanguageId>() {

            @Override
            public String getColumnName() {
                return "language_id";
            }

            @Override
            public String getFieldName() {
                return "LanguageId";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<Integer> getFieldClass(){
                return  Integer.class;
            }

            @Override
            public Integer getFieldValue(LanguageId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"LanguageId");
                return  entity.getLanguageId();
            }

            @Override
            public void setFieldValue(LanguageId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"LanguageId");
                entity.setLanguageId(param);
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