package io.daobab.example.daobab_vs_jpa_criteria.jpa.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="INGREDIENT",schema="")
@Cacheable(false)
public class _Ingredient {
	
	
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
