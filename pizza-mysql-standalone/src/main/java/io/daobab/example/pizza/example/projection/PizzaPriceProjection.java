package io.daobab.example.pizza.example.projection;

public class PizzaPriceProjection {
	
	private String name;
	private Double price;
	private String size;
	
	public PizzaPriceProjection(String name,String size,Double price) {
		this.setName(name);
		this.setSize(size);
		this.setPrice(price);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return getName()+" "+ getSize()+" "+getPrice();
	}

}
