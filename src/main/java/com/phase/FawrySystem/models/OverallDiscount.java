package com.phase.FawrySystem.models;

public class OverallDiscount implements Discount  {

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



}
