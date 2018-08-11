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
//@SequenceGenerator(name = "PIZZA_SEQ2", sequenceName = "PIZZA_SEQ2", allocationSize = 1)
@Table(name="PIZZA",schema="")
@Cacheable(false)
public class PizzaHibernateEager {
	
	
	@Id
	@Column(name="PIZZA_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
    @ManyToMany(cascade = { CascadeType.ALL },fetch=FetchType.EAGER)
    @JoinTable(
        name = "Pizza_Ingredient", 
        joinColumns = { @JoinColumn(name = "pizza_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
	private List<IngredientHibernate> ingredients;
	


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
	public List<IngredientHibernate> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<IngredientHibernate> ingredients) {
		this.ingredients = ingredients;
	}


	

}
