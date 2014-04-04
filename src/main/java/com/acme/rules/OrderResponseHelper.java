package com.acme.rules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.redhat.example.drools.webservice.OrderOutput;

public class OrderResponseHelper {

	public OrderOutput expeditedOutput(){
		OrderOutput standardOutput = new OrderOutput();
		standardOutput.setEffectiveDate(returnTargetDate(2));
		standardOutput.setResult("Expedited");
		return standardOutput;
	}
	
	public OrderOutput priorityOutput(){
		OrderOutput priorityOutput = new OrderOutput();
		priorityOutput.setEffectiveDate(returnTargetDate(4));
		priorityOutput.setResult("Priority");
		return priorityOutput;
	}

	public OrderOutput standardOutput(){
		OrderOutput standardOutput = new OrderOutput();
		standardOutput.setEffectiveDate(returnTargetDate(6));
		standardOutput.setResult("Standard");
		return standardOutput;
	}
	

	
	private String returnTargetDate(int dateFromToday){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_WEEK, dateFromToday);
		Date date = calendar.getTime(); 
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = format1.format(date);
		return date1;
	}
	
}
