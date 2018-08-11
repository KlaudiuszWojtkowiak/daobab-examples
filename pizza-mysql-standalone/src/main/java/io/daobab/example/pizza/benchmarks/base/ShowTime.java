package io.daobab.example.pizza.benchmarks.base;

import java.util.function.Supplier;

public interface ShowTime {
	
	@SuppressWarnings("static-access")
	public  static <D,H> void compare(Supplier<D> daobabquery,Supplier<H> jpaquery,int loops) {
	
	System.out.println("First execution to build connection and wait 1 sec...");
	daobabquery.get();
	jpaquery.get();
	try {
		Thread.currentThread().sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	long begin=System.currentTimeMillis();
			
			for (int i=0;i<loops;i++) {
				daobabquery.get();
			}
			
			String daobabsummary=ShowTime.show("Daobab time:", begin, System.currentTimeMillis());
			begin=System.currentTimeMillis();
			
			for (int i=0;i<loops;i++) {
				jpaquery.get();
			}
			
			String jpasummary=ShowTime.show("JPA time:", begin, System.currentTimeMillis());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("*********************************************************************************************");
			System.out.println("Comparation summary for "+loops+" loops: ");
			System.out.println(daobabsummary);
			System.out.println(jpasummary);
			System.out.println("*********************************************************************************************");
			
			
			
		}
	
	
	
	
	
	
	public  static <D,H> void compareCache(Supplier<D> noncachedquery,Supplier<H> cachequery,int loops) {
		
	System.out.println("First execution to build connection and wait 1 sec...");
	noncachedquery.get();
	cachequery.get();
	try {
		Thread.currentThread().sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	long begin=System.currentTimeMillis();
			
			for (int i=0;i<loops;i++) {
				noncachedquery.get();
			}
			
			String nocachedsummary=ShowTime.show("No cached dao execution time:", begin, System.currentTimeMillis());
			long begin2=System.currentTimeMillis();
			
			for (int i=0;i<loops;i++) {
				cachequery.get();
			}
			
			String cachedsummary=ShowTime.show("Cached dao execution time:", begin2, System.currentTimeMillis());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("*********************************************************************************************");
			System.out.println("Comparation summary for "+loops+" loops: ");
			System.out.println(nocachedsummary);
			System.out.println(cachedsummary);
			System.out.println("*********************************************************************************************");
			
			
			
		}
		
		public static String show(String description,long begin,long end) {
			long millis=end-begin;
			long second = (millis / 1000) % 60;
			long minute = (millis / (1000 * 60)) % 60;
			long hour = (millis / (1000 * 60 * 60)) % 24;
	
			String time = String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
			return (description+" "+time);
		}

}
