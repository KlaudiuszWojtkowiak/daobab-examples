package io.daobab.example.pizza.example.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import io.daobab.example.pizza.dao.entity.Customer;

public interface GeneratorCustomer {
	
	
	public static List<Customer> generate(int count) {
		 List<Customer> rv=new LinkedList<>();
		if (count<=0) return rv;
		for (int i=0;i<count;i++) {
			rv.add(generate());
		}
		return rv;
	}
	
	
	public static Customer generate() {
		Customer rv=new Customer();
		
		Random r=new Random();
		
		
		
		
		rv.setName(GeneratorFirstName.getFirstName()+" "+GeneratorLastName.getLastName());
		rv.setPhone(""+r.nextInt(999999999));
		rv.setAdress(GeneratorStreet.getStreetName()+" "+ r.nextInt(100));
		rv.setInsertDate(GeneratorDate2018.generateDate2018());
		return rv;
		
	}
	

}
