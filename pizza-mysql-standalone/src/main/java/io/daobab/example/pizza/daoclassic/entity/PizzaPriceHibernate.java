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
@SequenceGenerator(name = "PIZZA_PRICE_SEQ", sequenceName = "PIZZA_PRICE_SEQ", allocationSize = 1)
@Table(name="PIZZA_PRICE",schema="")
@Cacheable(false)
public class PizzaPriceHibernate {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PIZZA_PRICE_SEQ")
	@Column(name="PIZZA_PRICE_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaPrizeId;
	
	@Column(name="PIZZA_SIZE_ID")
	private Integer pizzaSizeId;
	
	@Column(name="PIZZA_ID")
	private Integer pizzaId;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="INSERT_DATE")
	private Date insertDate;

	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
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
