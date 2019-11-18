package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface ActorId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: actor_id,
     * db type: SMALLINT
     */
    default Integer getActorId(){return getColumnParam("ActorId");}
    default E setActorId(Integer val){setColumnParam("ActorId",val); return (E)this;}

    default Column<E,Integer,ActorId> colActorId(){
        return new Column<E,Integer,ActorId>() {

            @Override
            public String getColumnName() {
                return "actor_id";
            }

            @Override
            public String getFieldName() {
                return "ActorId";
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
            public Integer getColumnValue(ActorId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"ActorId");
                return  entity.getActorId();
            }

            @Override
            public void setColumnValue(ActorId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"ActorId");
                entity.setActorId(param);
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