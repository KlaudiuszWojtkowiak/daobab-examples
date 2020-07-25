package io.daobab.example;

import io.daobab.Select;
import io.daobab.example.pizza.PizzaDataBase;
import io.daobab.example.pizza.PizzaTables;

public class App implements PizzaTables {
    PizzaDataBase db=new PizzaDataBase();


    public void start(){

        Select.many(db,tabPizza.colName()).orderAscBy(tabPizza.colName()).forEach(System.out::println);


    }


    public static void main( String[] args ){
        App a=new App();
        a.start();

    }
}
