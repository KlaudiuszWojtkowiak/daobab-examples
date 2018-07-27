package io.daobab.example.pizza.example.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.elephantdrummer.dictionary.DictPeriod;

public interface GeneratorDate2018 {
	
	
	public static Date generateDate2018() {
		Random r=new Random();
		
		SimpleDateFormat fDsdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date dtfrom=null;
		try {
			dtfrom = fDsdf.parse("2018-01-01 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int day=r.nextInt(356);
		int hour=r.nextInt(24);
		int minute=r.nextInt(60);
		
		return new Date(dtfrom.getTime()+day*DictPeriod.PERIOD_DAY+hour*DictPeriod.PERIOD_HOUR+minute*DictPeriod.PERIOD_MINUTE);
		
		
	}

}
