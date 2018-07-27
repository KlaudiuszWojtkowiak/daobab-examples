package io.daobab.example.pizza.example;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.elephantdrummer.DrummerBoot;
import com.elephantdrummer.annotation.DrummerJob;
import com.elephantdrummer.annotation.trigger.Every;
import com.elephantdrummer.dictionary.DictPeriod;
import com.elephantdrummer.scope.DrummerObservable;

import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;

public class _31_DrummerJobSchedulling  implements DaobabExample,DrummerObservable{


	@PostConstruct
	public void init() {
		//Drummer standallone initialisation for one bean
		DrummerBoot db=new DrummerBoot();
		List<DrummerObservable> drummerObservables=new LinkedList<>();
		drummerObservables.add(this);
		db.boot(drummerObservables);
	}
	
	
	@DrummerJob(every=@Every(second=3))
	public void job() {
		System.out.println("hello this is Drummer Job. Visit www.elephantdrummer.com");
	}
	
	@Override
	public void test() {
		System.out.println("waiting...");
		try {
			Thread.sleep(30*DictPeriod.PERIOD_SECOND);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("... waiting finished");
	}
	
		public static void main(String[] args) {
			Executor.runTest(_31_DrummerJobSchedulling.class);
		}


}
