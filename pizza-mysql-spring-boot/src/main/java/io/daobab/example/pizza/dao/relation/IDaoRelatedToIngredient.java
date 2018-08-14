package io.daobab.example.pizza.dao.relation;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.relation.RelatedToIngredient;
import io.daobab.model.DaoColumn;
import io.daobab.model.DaoRelation;
import io.daobab.structure.IDao;

public interface IDaoRelatedToIngredient<E extends RelatedToIngredient> extends IDao<E>{
	
	@Column(name="INGREDIENT_ID")
	public default DaoColumn<E,Integer> colIngredientId(){
			return define("ingredientId");
		};
		
		
		@Column(name="INGREDIENT_ID")
		public default DaoRelation<E,Integer,RelatedToIngredient> relIngredient(){
				return new DaoRelation<>(colIngredientId(),r->r.getIngredientId());
			};

}
