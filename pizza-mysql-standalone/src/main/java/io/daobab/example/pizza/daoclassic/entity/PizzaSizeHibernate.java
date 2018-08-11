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
@SequenceGenerator(name = "PIZZA_SIZE_SEQ", sequenceName = "PIZZA_SIZE_SEQ", allocationSize = 1)
@Table(name="PIZZA_SIZE",schema="")
@Cacheable(false)
public class PizzaSizeHibernate {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PIZZA_SIZE_SEQ")
	@Column(name="PIZZA_SIZE_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaSizeId;

	@Column(name="NAME")
	private String name;
	

	@Column(name="cm")
	private String cm;
	
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
	public Integer getPizzaSizeId() {
		return pizzaSizeId;
	}
	public void setPizzaSizeId(Integer pizzaSizeId) {
		this.pizzaSizeId = pizzaSizeId;
	}

	
	

}
