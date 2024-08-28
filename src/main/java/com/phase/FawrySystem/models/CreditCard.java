package com.phase.FawrySystem.models;


public class CreditCard implements Payment{

	private String creditCardNumber;
	private String creditCardPassword;
	private int avalAmount=0;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String CreditCardNumber) 
	{
		creditCardNumber = CreditCardNumber;
	}
	public String getCreditCardPassword() 
	{
		return creditCardPassword;
	}
	public void setCreditCardPassword(String CreditCardPassword) 
	{
		creditCardPassword = CreditCardPassword;
	}
	
	public void setAvalAmount(int Amount) 
	{
		avalAmount = Amount;
	}
	
	public int GetavalAmount() {
		return avalAmount;
	}
	@Override
	public void Process(int a,int b) {
		if(b>0) {a=a-(a/b);}
		avalAmount -= a;
	}

}
