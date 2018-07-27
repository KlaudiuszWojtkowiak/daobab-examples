package io.daobab.example.pizza;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import io.daobab.example.pizza.example.base.DaobabExample;



public class Starter implements Runnable{
	
	private @Inject @Any Instance<DaobabExample> tests;
	
	  public static void main(String[] args) {
		
		Weld weld = new Weld();
	    WeldContainer container = weld.initialize();
	    Starter application = container.select(Starter.class).get();
	    application.run();
	    weld.shutdown();
	    
	    
	  }


	  


	@Override
	public void run() {
		
		List<DaobabExample> ln=new LinkedList<>();
		tests.forEach(t->ln.add(t));
		ln.sort(new Comparator<DaobabExample>() {

			@Override
			public int compare(DaobabExample o1, DaobabExample o2) {
//				if (o1.getOrder()>o2.getOrder()) return 1;
//				if (o1.getOrder()==o2.getOrder()) return 0;
				return -1;
			}
		});
		
		ln.forEach(t->System.out.println(t.getClass().getSimpleName()));
		
		executeTest();
		
	}
	  
	public void executeTest() {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("type number to execute an example or '999' to quit:");
		int myint = keyboard.nextInt();
		if (myint==999) {
			keyboard.close();
			return;
		}
		tests.forEach(p->{
			if (p.getClass().getSimpleName().replaceAll("_0", "_").startsWith("_"+myint+"_")) {
				System.out.println("Found example no: "+myint+" into classs "+p.getClass().getSimpleName()+" .... running....");
				p.test();
			}
		});
		

		System.out.println("no test for no: "+myint);
		executeTest();
		
		
	}
	
}
