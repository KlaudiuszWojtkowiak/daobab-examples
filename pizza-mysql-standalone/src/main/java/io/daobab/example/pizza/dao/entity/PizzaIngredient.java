package io.daobab.example.pizza.dao.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.daobab.example.pizza.dao.entity.relation.RelatedToIngredient;
import io.daobab.example.pizza.dao.entity.relation.RelatedToPizza;


@Entity
@Table(name="PIZZA_INGREDIENT",schema="")
@Cacheable(false)
public class PizzaIngredient implements RelatedToPizza,RelatedToIngredient,Serializable{
	
	private static final long serialVersionUID = -3609288408352723433L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PIZZA_INGREDIENT_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaIngredientId;
	
	@Column(name="PIZZA_ID")
	private Integer pizzaId;
	
	@Column(name="INGREDIENT_ID")
	private Integer ingredientId;
	

	@Override
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
	@Override
	public Integer getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}
	

}
