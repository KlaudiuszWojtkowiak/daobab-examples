package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface RentalDuration<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: rental_duration,
     * db type: TINYINT
     */
    default Integer getRentalDuration(){return getColumnParam("RentalDuration");}
    default E setRentalDuration(Integer val){setColumnParam("RentalDuration",val); return (E)this;}

    default Column<E,Integer,RentalDuration> colRentalDuration(){
        return new Column<E,Integer,RentalDuration>() {

            @Override
            public String getColumnName() {
                return "rental_duration";
            }

            @Override
            public String getFieldName() {
                return "RentalDuration";
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
            public Integer getColumnValue(RentalDuration entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"RentalDuration");
                return  entity.getRentalDuration();
            }

            @Override
            public void setColumnValue(RentalDuration entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"RentalDuration");
                entity.setRentalDuration(param);
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