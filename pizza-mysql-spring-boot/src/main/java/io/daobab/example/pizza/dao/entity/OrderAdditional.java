package io.daobab.example.pizza.dao.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.daobab.example.pizza.dao.entity.relation.RelatedToIngredient;
import io.daobab.example.pizza.dao.entity.relation.RelatedToOrderPizza;


@Entity
@Table(name="ORDER_ADDITIONAL",schema="")
@Cacheable(false)
public class OrderAdditional implements RelatedToIngredient,RelatedToOrderPizza{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ADDITIONAL_ID", unique=true, nullable=false, precision=13)
	private Integer orderAdditionalId;
	
	@Column(name="ORDER_PIZZA_ID")
	private Integer orderPizzaId;
	
	@Column(name="INGREDIENT_ID")
	private Integer ingredientId;
	


	@Override
	public Integer getOrderPizzaId() {
		return orderPizzaId;
	}
	public void setOrderPizzaId(Integer orderPizzaId) {
		this.orderPizzaId = orderPizzaId;
	}

	public Integer getOrderAdditionalId() {
		return orderAdditionalId;
	}
	public void setOrderAdditionalId(Integer orderAdditionalId) {
		this.orderAdditionalId = orderAdditionalId;
	}
	@Override
	public Integer getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	
	
	
	

}
