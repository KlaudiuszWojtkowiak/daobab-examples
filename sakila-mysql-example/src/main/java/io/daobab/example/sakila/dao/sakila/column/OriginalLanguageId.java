package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface OriginalLanguageId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: original_language_id,
     * db type: TINYINT
     */
    default Integer getOriginalLanguageId(){return getColumnParam("OriginalLanguageId");}
    default E setOriginalLanguageId(Integer val){setColumnParam("OriginalLanguageId",val); return (E)this;}

    default Column<E,Integer,OriginalLanguageId> colOriginalLanguageId(){
        return new Column<E,Integer,OriginalLanguageId>() {

            @Override
            public String getColumnName() {
                return "original_language_id";
            }

            @Override
            public String getFieldName() {
                return "OriginalLanguageId";
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
            public Integer getFieldValue(OriginalLanguageId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"OriginalLanguageId");
                return  entity.getOriginalLanguageId();
            }

            @Override
            public void setFieldValue(OriginalLanguageId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"OriginalLanguageId");
                entity.setOriginalLanguageId(param);
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