package com.redhat.example.drools.webservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()

public class OrderBean {

	private String customer;
	private String loyaltyLevel;
	private String model;
	private int quantity;
	private String shippingPriority;
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getLoyaltyLevel() {
		return loyaltyLevel;
	}
	public void setLoyaltyLevel(String loyaltyLevel) {
		this.loyaltyLevel = loyaltyLevel;
	}
	public String getShippingPriority() {
		return shippingPriority;
	}
	public void setShippingPriority(String shippingPriority) {
		this.shippingPriority = shippingPriority;
	}	
}
