package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface Sid<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: SID,
     * db type: TINYINT
     */
    default Integer getSid(){return getColumnParam("Sid");}
    default E setSid(Integer val){setColumnParam("Sid",val); return (E)this;}

    default Column<E,Integer,Sid> colSid(){
        return new Column<E,Integer,Sid>() {

            @Override
            public String getColumnName() {
                return "SID";
            }

            @Override
            public String getFieldName() {
                return "Sid";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<Integer> getColumnClass(){
                return  Integer.class;
            }

            @Override
            public Integer getColumnValue(Sid entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Sid");
                return  entity.getSid();
            }

            @Override
            public void setColumnValue(Sid entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Sid");
                entity.setSid(param);
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