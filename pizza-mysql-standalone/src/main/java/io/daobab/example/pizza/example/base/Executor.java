package io.daobab.example.pizza.example.base;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Executor {
	
	public static void runTest(Class<? extends DaobabExample> clazz) {
		

		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel","ERROR");
		System.setProperty("org.slf4j.simpleLogger.log.org.jboss.weld.ClassLoading","ERROR");
		System.setProperty("org.jboss.weld.Bootstrap.level","WARNING");
		
//		org.slf4j.simpleLogger.log.org.jboss.weld.ClassLoading s;

				
		Weld weld = new Weld();
		weld.property("org.jboss.weld.Bootstrap.level","WARNING");
		weld.property("org.slf4j.simpleLogger.defaultLogLevel","ERROR");
		weld.property("org.slf4j.simpleLogger.log.org.jboss.weld.ClassLoading","ERROR");
		WeldContainer container = weld.initialize();
		DaobabExample application = container.select(clazz).get();
		application.test();
		weld.shutdown();
		System.exit(4);
	}

}
