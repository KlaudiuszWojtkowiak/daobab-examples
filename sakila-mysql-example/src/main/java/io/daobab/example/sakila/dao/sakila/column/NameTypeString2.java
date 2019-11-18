package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface NameTypeString2<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: name,
     * db type: CHAR
     */
    default String getNameTypeString2(){return getColumnParam("NameTypeString2");}
    default E setNameTypeString2(String val){setColumnParam("NameTypeString2",val); return (E)this;}

    default Column<E,String,NameTypeString2> colNameTypeString2(){
        return new Column<E,String,NameTypeString2>() {

            @Override
            public String getColumnName() {
                return "name";
            }

            @Override
            public String getFieldName() {
                return "NameTypeString2";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<String> getColumnClass(){
                return  String.class;
            }

            @Override
            public String getColumnValue(NameTypeString2 entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"NameTypeString2");
                return  entity.getNameTypeString2();
            }

            @Override
            public void setColumnValue(NameTypeString2 entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"NameTypeString2");
                entity.setNameTypeString2(param);
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