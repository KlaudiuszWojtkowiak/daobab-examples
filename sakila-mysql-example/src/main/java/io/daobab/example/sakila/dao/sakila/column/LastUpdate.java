package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.sql.Timestamp;

public interface LastUpdate<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: last_update,
     * db type: TIMESTAMP
     */
    default Timestamp getLastUpdate(){return getColumnParam("LastUpdate");}
    default E setLastUpdate(Timestamp val){setColumnParam("LastUpdate",val); return (E)this;}

    default Column<E,Timestamp,LastUpdate> colLastUpdate(){
        return new Column<E,Timestamp,LastUpdate>() {

            @Override
            public String getColumnName() {
                return "last_update";
            }

            @Override
            public String getFieldName() {
                return "LastUpdate";
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
            public Timestamp getFieldValue(LastUpdate entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"LastUpdate");
                return  entity.getLastUpdate();
            }

            @Override
            public void setFieldValue(LastUpdate entity, Timestamp param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"LastUpdate");
                entity.setLastUpdate(param);
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