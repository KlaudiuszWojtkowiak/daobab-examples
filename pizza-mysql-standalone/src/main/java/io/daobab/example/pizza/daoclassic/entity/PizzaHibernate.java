package io.daobab.example.pizza.daoclassic.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(name = "PIZZA_SEQ", sequenceName = "PIZZA_SEQ", allocationSize = 1)
@Table(name="PIZZA",schema="")
@Cacheable(false)
public class PizzaHibernate {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PIZZA_SEQ")
	@Column(name="PIZZA_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;

	


	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

}
