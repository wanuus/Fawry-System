package com.phase.FawrySystem.models;

public class SpecificDiscount implements Discount {

	private String service;
	private int Discount;
	@Override
	public void setDiscount(int a) {
		Discount=a;
	}

	@Override
	public int getDiscount() {
		// TODO Auto-generated method stub
		return Discount;
	}
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

}
