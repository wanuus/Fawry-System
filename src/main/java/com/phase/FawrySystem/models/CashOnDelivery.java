package com.phase.FawrySystem.models;
public class CashOnDelivery implements Payment 
{

	private int Amount=0;
	
	public void setAmount(int amount) 
	{
		Amount += amount;
		
	}
	@Override
	public int GetavalAmount() {
		return Amount;
	}
	@Override
	public void Process(int a,int b) {
		if(b>0) {a=a-(a/b);}
		Amount -= a;
	}

}
