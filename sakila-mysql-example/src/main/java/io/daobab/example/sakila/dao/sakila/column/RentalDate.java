package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.sql.Timestamp;

public interface RentalDate<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: rental_date,
     * db type: TIMESTAMP
     */
    default Timestamp getRentalDate(){return getColumnParam("RentalDate");}
    default E setRentalDate(Timestamp val){setColumnParam("RentalDate",val); return (E)this;}

    default Column<E,Timestamp,RentalDate> colRentalDate(){
        return new Column<E,Timestamp,RentalDate>() {

            @Override
            public String getColumnName() {
                return "rental_date";
            }

            @Override
            public String getFieldName() {
                return "RentalDate";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<Timestamp> getColumnClass(){
                return  Timestamp.class;
            }

            @Override
            public Timestamp getColumnValue(RentalDate entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"RentalDate");
                return  entity.getRentalDate();
            }

            @Override
            public void setColumnValue(RentalDate entity, Timestamp param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"RentalDate");
                entity.setRentalDate(param);
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