package io.daobab.example.sakila;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"io.daobab"})
public class SpringBootWebApplication {

    //Run it visit  http://localhost:9111/test/t01
	public static void main(String[] args)  {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
	
	

}
