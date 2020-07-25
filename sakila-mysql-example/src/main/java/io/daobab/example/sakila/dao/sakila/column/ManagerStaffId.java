package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface ManagerStaffId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: manager_staff_id,
     * db type: TINYINT
     */
    default Integer getManagerStaffId(){return getColumnParam("ManagerStaffId");}
    default E setManagerStaffId(Integer val){setColumnParam("ManagerStaffId",val); return (E)this;}

    default Column<E,Integer,ManagerStaffId> colManagerStaffId(){
        return new Column<E,Integer,ManagerStaffId>() {

            @Override
            public String getColumnName() {
                return "manager_staff_id";
            }

            @Override
            public String getFieldName() {
                return "ManagerStaffId";
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
            public Integer getFieldValue(ManagerStaffId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"ManagerStaffId");
                return  entity.getManagerStaffId();
            }

            @Override
            public void setFieldValue(ManagerStaffId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"ManagerStaffId");
                entity.setManagerStaffId(param);
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