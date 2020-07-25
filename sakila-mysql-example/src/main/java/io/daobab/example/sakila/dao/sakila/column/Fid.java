package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface Fid<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: FID,
     * db type: SMALLINT
     */
    default Integer getFid(){return getColumnParam("Fid");}
    default E setFid(Integer val){setColumnParam("Fid",val); return (E)this;}

    default Column<E,Integer,Fid> colFid(){
        return new Column<E,Integer,Fid>() {

            @Override
            public String getColumnName() {
                return "FID";
            }

            @Override
            public String getFieldName() {
                return "Fid";
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
            public Integer getFieldValue(Fid entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Fid");
                return  entity.getFid();
            }

            @Override
            public void setFieldValue(Fid entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Fid");
                entity.setFid(param);
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