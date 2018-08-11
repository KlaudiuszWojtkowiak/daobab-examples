package io.daobab.example.pizza.daoclassic.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(name = "INGREDIENT_SEQ", sequenceName = "INGREDIENT_SEQ", allocationSize = 1)
@Table(name="INGREDIENT",schema="")
@Cacheable(false)
public class IngredientHibernate{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INGREDIENT_SEQ")
	@Column(name="INGREDIENT_ID", unique=true, nullable=false, precision=13)
	private Integer ingredientId;
	@Column(name="NAME")
	private String name;
	@Column(name="VEGETARIAN")
	private String vegetarian;
	@Column(name="VEGAN")
	private String vegan;
	@Column(name="HOT_RANGE")
	private String hotRange;
	
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
	public String getVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(String vegetarian) {
		this.vegetarian = vegetarian;
	}
	public String getVegan() {
		return vegan;
	}
	public void setVegan(String vegan) {
		this.vegan = vegan;
	}
	public String getHotRange() {
		return hotRange;
	}
	public void setHotRange(String hotRange) {
		this.hotRange = hotRange;
	}

	

}
