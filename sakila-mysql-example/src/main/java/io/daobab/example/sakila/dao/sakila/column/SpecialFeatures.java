package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.String;

public interface SpecialFeatures<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: special_features,
     * db type: CHAR
     */
    default String getSpecialFeatures(){return getColumnParam("SpecialFeatures");}
    default E setSpecialFeatures(String val){setColumnParam("SpecialFeatures",val); return (E)this;}

    default Column<E,String,SpecialFeatures> colSpecialFeatures(){
        return new Column<E,String,SpecialFeatures>() {

            @Override
            public String getColumnName() {
                return "special_features";
            }

            @Override
            public String getFieldName() {
                return "SpecialFeatures";
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
            public String getColumnValue(SpecialFeatures entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"SpecialFeatures");
                return  entity.getSpecialFeatures();
            }

            @Override
            public void setColumnValue(SpecialFeatures entity, String param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"SpecialFeatures");
                entity.setSpecialFeatures(param);
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