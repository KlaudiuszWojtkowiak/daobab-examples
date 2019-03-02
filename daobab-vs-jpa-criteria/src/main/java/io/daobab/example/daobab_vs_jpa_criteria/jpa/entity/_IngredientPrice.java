package io.daobab.example.daobab_vs_jpa_criteria.jpa.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="INGREDIENT_PRICE",schema="")
@Cacheable(false)
public class _IngredientPrice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INGREDIENT_PRICE_ID", unique=true, nullable=false, precision=13)
	private Integer ingredientPriceId;
	
	@Column(name="INGREDIENT_ID")
	private Integer ingredientId;

	@Column(name="PIZZA_SIZE_ID")
	private Integer pizzaSizeId;
	
	@Column(name="PRICE")
	private Double price;
	


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

	
	
}
