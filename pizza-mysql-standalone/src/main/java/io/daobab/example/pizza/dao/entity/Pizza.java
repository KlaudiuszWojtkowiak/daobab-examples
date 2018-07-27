package io.daobab.example.pizza.dao.entity;

import java.util.List;
import java.util.function.Supplier;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.daobab.example.pizza.dao.entity.relation.RelatedToDescription;
import io.daobab.example.pizza.dao.entity.relation.RelatedToName;
import io.daobab.example.pizza.dao.entity.relation.RelatedToPizza;


@Entity
@Table(name="PIZZA",schema="")
@Cacheable(false)
public class Pizza implements RelatedToPizza,RelatedToName,RelatedToDescription{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PIZZA_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Transient
	private List<PizzaPrice> priceList;
	
	@Transient
	private transient Supplier<List<PizzaPrice>> supplierPizzaPrice;
	
	@Transient
	private List<Ingredient> ingredients;
	
	@Transient
	private transient Supplier<List<Ingredient>> supplierLazyIngredients;
	
	public List<Ingredient> getLazyIngredients(){
		if (ingredients==null==false||getSupplierLazyIngredients()==null) return getIngredients();
		setIngredients(getSupplierLazyIngredients().get());
		return getIngredients();
	}
	
	public List<PizzaPrice> getLazyPizzaPriceList(){
		if (priceList==null==false||getSupplierPizzaPrice()==null) return getPriceList();
		setPriceList(getSupplierPizzaPrice().get());
		return getPriceList();
	}

	@Override
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Supplier<List<Ingredient>> getSupplierLazyIngredients() {
		return supplierLazyIngredients;
	}

	public void setSupplierLazyIngredients(Supplier<List<Ingredient>> supplierLazyIngredients) {
		this.supplierLazyIngredients = supplierLazyIngredients;
	}

	public List<PizzaPrice> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<PizzaPrice> priceList) {
		this.priceList = priceList;
	}

	public Supplier<List<PizzaPrice>> getSupplierPizzaPrice() {
		return supplierPizzaPrice;
	}

	public void setSupplierPizzaPrice(Supplier<List<PizzaPrice>> supplierPizzaPrice) {
		this.supplierPizzaPrice = supplierPizzaPrice;
	}


	

}
