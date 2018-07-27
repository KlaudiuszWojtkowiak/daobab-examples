package io.daobab.example.pizza.dao.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.daobab.example.pizza.dao.entity.relation.RelatedToPizza;
import io.daobab.example.pizza.dao.entity.relation.RelatedToPizzaSize;
import io.daobab.example.pizza.dao.entity.relation.RelatedToPrice;


@Entity
@Table(name="PIZZA_PRICE",schema="")
@Cacheable(false)
public class PizzaPrice implements RelatedToPizza,RelatedToPrice,RelatedToPizzaSize{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PIZZA_PRICE_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaPrizeId;
	
	@Column(name="PIZZA_SIZE_ID")
	private Integer pizzaSizeId;
	
	@Column(name="PIZZA_ID")
	private Integer pizzaId;
	
	@Column(name="PRICE")
	private Double price;
	
	@Override
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}

	@Override
	public Integer getPizzaSizeId() {
		return pizzaSizeId;
	}
	public void setPizzaSizeId(Integer pizzaSizeId) {
		this.pizzaSizeId = pizzaSizeId;
	}
	
	
	@Override
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	

}
