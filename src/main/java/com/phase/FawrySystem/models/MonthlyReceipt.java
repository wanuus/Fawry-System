package com.phase.FawrySystem.models;

import java.util.Map;

public class MonthlyReceipt implements ServiceProvider 
{
	private static int ID = 7;
	public static int getID() {
		return ID;
	}
	
	@Override
	public boolean Handler(Map<String, Object> mp) {
		 if(mp.get("mobilenumber") == null || mp.get("amount") == null|| mp.get("address") == null)
			 return false;
		 return true;
	}



}

