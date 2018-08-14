package io.daobab.example.pizza.dao.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.daobab.example.pizza.dao.entity.relation.RelatedToName;
import io.daobab.example.pizza.dao.entity.relation.RelatedToPizzaSize;


@Entity
@Table(name="PIZZA_SIZE",schema="")
@Cacheable(false)
public class PizzaSize implements RelatedToName,RelatedToPizzaSize{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PIZZA_SIZE_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaSizeId;

	@Column(name="NAME")
	private String name;
	

	@Column(name="cm")
	private String cm;
	

	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCm() {
		return cm;
	}
	public void setCm(String cm) {
		this.cm = cm;
	}
	@Override
	public Integer getPizzaSizeId() {
		return pizzaSizeId;
	}
	public void setPizzaSizeId(Integer pizzaSizeId) {
		this.pizzaSizeId = pizzaSizeId;
	}

	
	

}
