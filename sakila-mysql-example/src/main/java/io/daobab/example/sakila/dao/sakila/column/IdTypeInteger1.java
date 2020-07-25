package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface IdTypeInteger1<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: ID,
     * db type: SMALLINT
     */
    default Integer getIdTypeInteger1(){return getColumnParam("IdTypeInteger1");}
    default E setIdTypeInteger1(Integer val){setColumnParam("IdTypeInteger1",val); return (E)this;}

    default Column<E,Integer,IdTypeInteger1> colIdTypeInteger1(){
        return new Column<E,Integer,IdTypeInteger1>() {

            @Override
            public String getColumnName() {
                return "ID";
            }

            @Override
            public String getFieldName() {
                return "IdTypeInteger1";
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
            public Integer getFieldValue(IdTypeInteger1 entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"IdTypeInteger1");
                return  entity.getIdTypeInteger1();
            }

            @Override
            public void setFieldValue(IdTypeInteger1 entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"IdTypeInteger1");
                entity.setIdTypeInteger1(param);
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