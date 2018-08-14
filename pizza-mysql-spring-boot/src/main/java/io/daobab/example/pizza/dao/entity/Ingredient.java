package io.daobab.example.pizza.dao.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.daobab.example.pizza.dao.entity.relation.RelatedToIngredient;
import io.daobab.example.pizza.dao.entity.relation.RelatedToName;


@Entity
@Table(name="INGREDIENT",schema="")
@Cacheable(false)
public class Ingredient implements RelatedToIngredient,RelatedToName{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INGREDIENT_ID", unique=true, nullable=false, precision=13)
	private Integer ingredientId;
	@Column(name="NAME")
	private String name;
	@Column(name="VEGETARIAN")
	private Integer vegetarian;
	@Column(name="VEGAN")
	private Integer vegan;
	@Column(name="HOT_RANGE")
	private Integer hotRange;
	
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Integer getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}
	public Integer getVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(Integer vegetarian) {
		this.vegetarian = vegetarian;
	}
	public Integer getVegan() {
		return vegan;
	}
	public void setVegan(Integer vegan) {
		this.vegan = vegan;
	}
	public Integer getHotRange() {
		return hotRange;
	}
	public void setHotRange(Integer hotRange) {
		this.hotRange = hotRange;
	}

	

}
