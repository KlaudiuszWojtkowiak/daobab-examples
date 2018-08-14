package io.daobab.example.pizza.dao.entity;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.daobab.example.pizza.dao.entity.relation.RelatedToCustomer;
import io.daobab.example.pizza.dao.entity.relation.RelatedToInsertDate;
import io.daobab.example.pizza.dao.entity.relation.RelatedToOrderPizza;
import io.daobab.example.pizza.dao.entity.relation.RelatedToPizza;
import io.daobab.example.pizza.dao.entity.relation.RelatedToPizzaSize;
import io.daobab.example.pizza.dao.entity.relation.RelatedToPrice;


@Entity
@Table(name="ORDER_PIZZA",schema="")
@Cacheable(false)
public class OrderPizza implements RelatedToPizza,RelatedToCustomer,RelatedToPizzaSize,RelatedToPrice,RelatedToOrderPizza,RelatedToInsertDate{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_PIZZA_ID", unique=true, nullable=false, precision=13)
	private Integer orderPizzaId;
	
	@Column(name="PIZZA_ID")
	private Integer pizzaId;
	
	@Column(name="PIZZA_SIZE_ID")
	private Integer pizzaSizeId;
	
	@Column(name="CUSTOMER_ID")
	private Integer customerId;
	
	@Column(name="INSERT_DATE")
	private Date insertDate;

	@Column(name="DELIVER_DATE")
	private Date deliverDate;
	
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
	public Integer getOrderPizzaId() {
		return orderPizzaId;
	}
	public void setOrderPizzaId(Integer orderPizzaId) {
		this.orderPizzaId = orderPizzaId;
	}
	@Override
	public Integer getPizzaSizeId() {
		return pizzaSizeId;
	}
	public void setPizzaSizeId(Integer sizeId) {
		this.pizzaSizeId = sizeId;
	}
	@Override
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	@Override
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	@Override
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
