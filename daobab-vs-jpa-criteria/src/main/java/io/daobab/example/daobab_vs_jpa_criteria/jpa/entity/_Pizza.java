package io.daobab.example.daobab_vs_jpa_criteria.jpa.entity;

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



@Entity
@Table(name="PIZZA",schema="")
@Cacheable(false)
public class _Pizza {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PIZZA_ID", unique=true, nullable=false, precision=13)
	private Integer pizzaId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Transient
	private List<_PizzaPrice> priceList;
	
	@Transient
	private transient Supplier<List<_PizzaPrice>> supplierPizzaPrice;
	
	@Transient
	private List<_Ingredient> ingredients;
	
	@Transient
	private transient Supplier<List<_Ingredient>> supplierLazyIngredients;
	
	public List<_Ingredient> getLazyIngredients(){
		if (ingredients==null==false||getSupplierLazyIngredients()==null) return getIngredients();
		setIngredients(getSupplierLazyIngredients().get());
		return getIngredients();
	}
	
	public List<_PizzaPrice> getLazyPizzaPriceList(){
		if (priceList==null==false||getSupplierPizzaPrice()==null) return getPriceList();
		setPriceList(getSupplierPizzaPrice().get());
		return getPriceList();
	}

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
	public List<_Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<_Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Supplier<List<_Ingredient>> getSupplierLazyIngredients() {
		return supplierLazyIngredients;
	}

	public void setSupplierLazyIngredients(Supplier<List<_Ingredient>> supplierLazyIngredients) {
		this.supplierLazyIngredients = supplierLazyIngredients;
	}

	public List<_PizzaPrice> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<_PizzaPrice> priceList) {
		this.priceList = priceList;
	}

	public Supplier<List<_PizzaPrice>> getSupplierPizzaPrice() {
		return supplierPizzaPrice;
	}

	public void setSupplierPizzaPrice(Supplier<List<_PizzaPrice>> supplierPizzaPrice) {
		this.supplierPizzaPrice = supplierPizzaPrice;
	}


	

}
