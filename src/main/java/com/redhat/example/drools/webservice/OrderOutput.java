package com.redhat.example.drools.webservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class OrderOutput {

	private String result;
	private String effectiveDate;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}	
}
