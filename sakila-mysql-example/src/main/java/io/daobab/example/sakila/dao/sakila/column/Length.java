package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface Length<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: length,
     * db type: SMALLINT
     */
    default Integer getLength(){return getColumnParam("Length");}
    default E setLength(Integer val){setColumnParam("Length",val); return (E)this;}

    default Column<E,Integer,Length> colLength(){
        return new Column<E,Integer,Length>() {

            @Override
            public String getColumnName() {
                return "length";
            }

            @Override
            public String getFieldName() {
                return "Length";
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
            public Integer getFieldValue(Length entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Length");
                return  entity.getLength();
            }

            @Override
            public void setFieldValue(Length entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Length");
                entity.setLength(param);
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