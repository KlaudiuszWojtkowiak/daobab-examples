package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.ColumnRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface CategoryId<E extends EntityMap> extends ColumnRelationMap<E> {


    /**
     * db name: category_id,
     * db type: TINYINT
     */
    default Integer getCategoryId(){return getColumnParam("CategoryId");}
    default E setCategoryId(Integer val){setColumnParam("CategoryId",val); return (E)this;}

    default Column<E,Integer,CategoryId> colCategoryId(){
        return new Column<E,Integer,CategoryId>() {

            @Override
            public String getColumnName() {
                return "category_id";
            }

            @Override
            public String getFieldName() {
                return "CategoryId";
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
            public Integer getColumnValue(CategoryId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"CategoryId");
                return  entity.getCategoryId();
            }

            @Override
            public void setColumnValue(CategoryId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"CategoryId");
                entity.setCategoryId(param);
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