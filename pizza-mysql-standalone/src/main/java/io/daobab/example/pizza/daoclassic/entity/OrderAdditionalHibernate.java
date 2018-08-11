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
@SequenceGenerator(name = "ORDER_ADDITIONAL_SEQ", sequenceName = "ORDER_ADDITIONAL_SEQ", allocationSize = 1)
@Table(name="ORDER_ADDITIONAL",schema="")
@Cacheable(false)
public class OrderAdditionalHibernate {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_ADDITIONAL_SEQ")
	@Column(name="ORDER_ADDITIONAL_ID", unique=true, nullable=false, precision=13)
	private Integer orderAdditionalId;
	
	@Column(name="ORDER_PIZZA_ID")
	private Integer orderPizzaId;
	
	@Column(name="INGREDIENT_ID")
	private Integer ingredientId;
	
	
	@Column(name="INSERT_DATE")
	private Date insertDate;

	public Integer getOrderPizzaId() {
		return orderPizzaId;
	}
	public void setOrderPizzaId(Integer orderPizzaId) {
		this.orderPizzaId = orderPizzaId;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Integer getOrderAdditionalId() {
		return orderAdditionalId;
	}
	public void setOrderAdditionalId(Integer orderAdditionalId) {
		this.orderAdditionalId = orderAdditionalId;
	}
	public Integer getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	
	
	
	

}
