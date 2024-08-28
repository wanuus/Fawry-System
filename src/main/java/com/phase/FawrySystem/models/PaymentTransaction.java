package com.phase.FawrySystem.models;

public class PaymentTransaction extends Transaction 
{
	private String serviceprov;
	private int amount;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getServiceprovID() {
		return serviceprov;
	}
	public void setServiceprovID(String serviceprovID) {
		this.serviceprov = serviceprovID;
	}
}
