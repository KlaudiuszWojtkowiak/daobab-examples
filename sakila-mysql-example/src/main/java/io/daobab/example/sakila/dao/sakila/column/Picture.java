package io.daobab.example.sakila.dao.sakila.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;



public interface Picture<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: picture,
     * db type: LONGVARBINARY
     */
    default byte[] getPicture(){return getColumnParam("Picture");}
    default E setPicture(byte[] val){setColumnParam("Picture",val); return (E)this;}

    default Column<E,byte[],Picture> colPicture(){
        return new Column<E,byte[],Picture>() {

            @Override
            public String getColumnName() {
                return "picture";
            }

            @Override
            public String getFieldName() {
                return "Picture";
            }

            @Override
            public E getThisEntity(){
                return getEntity();
            }

            @Override
            public Class<byte[]> getFieldClass(){
                return  byte[].class;
            }

            @Override
            public byte[] getFieldValue(Picture entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"Picture");
                return  entity.getPicture();
            }

            @Override
            public void setFieldValue(Picture entity, byte[] param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"Picture");
                entity.setPicture(param);
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