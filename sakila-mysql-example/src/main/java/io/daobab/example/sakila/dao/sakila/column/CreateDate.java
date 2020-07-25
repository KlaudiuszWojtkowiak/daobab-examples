package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.sql.Timestamp;

public interface CreateDate<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: create_date,
     * db type: TIMESTAMP
     */
    default Timestamp getCreateDate(){return getColumnParam("CreateDate");}
    default E setCreateDate(Timestamp val){setColumnParam("CreateDate",val); return (E)this;}

    default Column<E,Timestamp,CreateDate> colCreateDate(){
        return new Column<E,Timestamp,CreateDate>() {

            @Override
            public String getColumnName() {
                return "create_date";
            }

            @Override
            public String getFieldName() {
                return "CreateDate";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<Timestamp> getFieldClass(){
                return  Timestamp.class;
            }

            @Override
            public Timestamp getFieldValue(CreateDate entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"CreateDate");
                return  entity.getCreateDate();
            }

            @Override
            public void setFieldValue(CreateDate entity, Timestamp param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"CreateDate");
                entity.setCreateDate(param);
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