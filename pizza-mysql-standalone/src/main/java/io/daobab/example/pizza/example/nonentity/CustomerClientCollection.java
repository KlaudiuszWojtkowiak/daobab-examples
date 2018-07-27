package io.daobab.example.pizza.example.nonentity;

import java.util.LinkedList;

import javax.inject.Singleton;

import io.daobab.cache.CachedList;
import io.daobab.model.DaoColumn;

@Singleton
public class CustomerClientCollection extends CachedList<Client>{

	public CustomerClientCollection() {
		super(new LinkedList<>(), Client.class);
	}

	private static final long serialVersionUID = 1L;
	
	
	public DaoColumn<Client,String> colFirstName(){
			return define("firstName");
		};
		
		public DaoColumn<Client,String> colLastName(){
			return define("lastName");
		};
		
		public DaoColumn<Client,Integer> colAge(){
			return define("age");
		};


}
