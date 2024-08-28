package com.phase.FawrySystem.models;

import java.util.Map;

public class CancerHospitalDonations implements ServiceProvider {

	private static int ID = 6;
	public static int getID() {
		return ID;
	}
	
	@Override
	public boolean Handler(Map<String, Object> mp) {
		 if( mp.get("amount") == null)
			 return false;
		 return true;
	}

	
	
}
