package com.phase.FawrySystem.models;


public class Refund 
{
	private String State;
	private int Amount;
	private int ID;
	private String Reason;
	private String Email;
	public String getState() 
	{
		return State;
	}
	public void setState(String state) 
	{
		State = state;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public  int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
