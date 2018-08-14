package io.daobab.example.pizza.dao;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.Ingredient;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToIngredient;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToName;
import io.daobab.model.DaoColumn;

public interface IDaoIngredient extends  IDaoRelatedToIngredient<Ingredient>,IDaoRelatedToName<Ingredient>{

	@Column(name="VEGETARIAN")
	public default DaoColumn<Ingredient,String> colVegetarian(){
		return define("vegetarian");
	};
	@Column(name="VEGAN")
	public default DaoColumn<Ingredient,String> colVegan(){
		return define("vegan");
	};
	@Column(name="HOT_RANGE")
	public default DaoColumn<Ingredient,String> colHotRange(){
		return define("hotRange");
	};
}
