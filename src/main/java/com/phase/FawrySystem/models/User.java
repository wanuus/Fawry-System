package com.phase.FawrySystem.models;
import java.util.*;
public class User 
{
	private String UserName;
	private String Password;
	private String Email;
	private CreditCard Creditcard = new CreditCard();
	private Wallet Wallet = new Wallet();
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) 
	{
		Email = email;
	}
	public CreditCard getCreditCard() {
		return Creditcard;
	}
	public void setCreditCard(CreditCard creditCard) {
		Creditcard = creditCard;
	}
	public Wallet getWallet() 
	{
		return Wallet;
	}
	public void setWallet(Wallet wallet) 
	{
		Wallet = wallet;
	}
	
	
}
