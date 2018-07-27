package io.daobab.example.pizza.example.base;

import java.util.Random;

public interface GeneratorStreet {
	
	

	
	public String[] streetArray=new String[] {
			"Barton Road",
			"Fann Street",
			"Macclesfield Road",
			"Ritchie Street",
			"St. Paul's Alley",
			"Scurr Street",
			"Sowerby Street",
			"Telegraph Hill",
			"Victoria Rise",
			"Watergate Walk"
	};
	
	public static String getStreetName() {
		Random r=new Random();
		return streetArray[r.nextInt(streetArray.length)];
	}
	

}
