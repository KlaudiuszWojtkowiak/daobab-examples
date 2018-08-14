package io.daobab.example.pizza;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages={"io.daobab"})
public class SpringBootWebApplication  {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
	
	

}