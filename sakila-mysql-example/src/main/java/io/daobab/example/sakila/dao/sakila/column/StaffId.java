package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface StaffId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: staff_id,
     * db type: TINYINT
     */
    default Integer getStaffId(){return getColumnParam("StaffId");}
    default E setStaffId(Integer val){setColumnParam("StaffId",val); return (E)this;}

    default Column<E,Integer,StaffId> colStaffId(){
        return new Column<E,Integer,StaffId>() {

            @Override
            public String getColumnName() {
                return "staff_id";
            }

            @Override
            public String getFieldName() {
                return "StaffId";
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
            public Integer getFieldValue(StaffId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"StaffId");
                return  entity.getStaffId();
            }

            @Override
            public void setFieldValue(StaffId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"StaffId");
                entity.setStaffId(param);
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