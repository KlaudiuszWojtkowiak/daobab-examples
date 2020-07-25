package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface IdTypeInteger2<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: ID,
     * db type: TINYINT
     */
    default Integer getIdTypeInteger2(){return getColumnParam("IdTypeInteger2");}
    default E setIdTypeInteger2(Integer val){setColumnParam("IdTypeInteger2",val); return (E)this;}

    default Column<E,Integer,IdTypeInteger2> colIdTypeInteger2(){
        return new Column<E,Integer,IdTypeInteger2>() {

            @Override
            public String getColumnName() {
                return "ID";
            }

            @Override
            public String getFieldName() {
                return "IdTypeInteger2";
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
            public Integer getFieldValue(IdTypeInteger2 entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"IdTypeInteger2");
                return  entity.getIdTypeInteger2();
            }

            @Override
            public void setFieldValue(IdTypeInteger2 entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"IdTypeInteger2");
                entity.setIdTypeInteger2(param);
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