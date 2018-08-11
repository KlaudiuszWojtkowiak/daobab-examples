package io.daobab.example.pizza.daoclassic.entity;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "INGREDIENT_PRICE_SEQ", sequenceName = "INGREDIENT_PRICE_SEQ", allocationSize = 1)
@Table(name="INGREDIENT_PRICE",schema="")
@Cacheable(false)
public class IngredientPriceHibernate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INGREDIENT_PRICE_SEQ")
	@Column(name="INGREDIENT_PRICE_ID", unique=true, nullable=false, precision=13)
	private Integer ingredientPriceId;
	
	@Column(name="INGREDIENT_ID")
	private Integer ingredientId;

	@Column(name="PIZZA_SIZE_ID")
	private Integer pizzaSizeId;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="INSERT_DATE")
	private Date insertDate;

	public Integer getIngredientPriceId() {
		return ingredientPriceId;
	}

	public void setIngredientPriceId(Integer ingredientPriceId) {
		this.ingredientPriceId = ingredientPriceId;
	}

	public Integer getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}

	public Integer getPizzaSizeId() {
		return pizzaSizeId;
	}

	public void setPizzaSizeId(Integer pizzaSizeId) {
		this.pizzaSizeId = pizzaSizeId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	
	
	
}
