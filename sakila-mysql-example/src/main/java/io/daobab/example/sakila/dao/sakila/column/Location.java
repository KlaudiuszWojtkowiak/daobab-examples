package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;



public interface Location<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: location,
     * db type: BINARY
     */
    default byte[] getLocation(){return getColumnParam("Location");}
    default E setLocation(byte[] val){setColumnParam("Location",val); return (E)this;}

    default Column<E,byte[],Location> colLocation(){
        return new Column<E,byte[],Location>() {

            @Override
            public String getColumnName() {
                return "location";
            }

            @Override
            public String getFieldName() {
                return "Location";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<byte[]> getColumnClass(){
                return  byte[].class;
            }

            @Override
            public byte[] getColumnValue(Location entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Location");
                return  entity.getLocation();
            }

            @Override
            public void setColumnValue(Location entity, byte[] param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Location");
                entity.setLocation(param);
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