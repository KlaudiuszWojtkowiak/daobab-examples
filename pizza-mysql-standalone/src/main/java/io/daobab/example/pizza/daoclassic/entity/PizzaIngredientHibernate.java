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
@SequenceGenerator(name = "PIZZA_INGREDIENT_SEQ", sequenceName = "PIZZA_INGREDIENT_SEQ", allocationSize = 1)
@Table(name="PIZZA_INGREDIENT",schema="")
@Cacheable(false)
public class PizzaIngredientHibernate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PIZZA_INGREDIENT_SEQ")
	@Column(name="PIZZA_INGREDIENT_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaIngredientId;
	
	@Column(name="PIZZA_ID")
	private Integer pizzaId;
	
	@Column(name="INGREDIENT_ID")
	private Integer ingredientId;
	

	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}

	
	public Integer getPizzaIngredientId() {
		return pizzaIngredientId;
	}
	public void setPizzaIngredientId(Integer pizzaIngredientId) {
		this.pizzaIngredientId = pizzaIngredientId;
	}
	public Integer getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}
	

}
