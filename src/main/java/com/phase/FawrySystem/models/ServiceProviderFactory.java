package com.phase.FawrySystem.models;

public class ServiceProviderFactory 
{
	private ServiceProvider service;

	public ServiceProvider ProviderCreator(String provider)
	{
		if(provider.equals("Vodafone") )
			service = new Vodafone();	
		else if(provider.equals("We") )
			service = new WE();
		else if(provider.equals("Orange") )
			service = new Orange();
		else if(provider.equals("Etisalat"))
			service = new Etisalat();
		else if(provider.equals("NGOsDonations"))
			service = new NGOsDonations();
        else if(provider.equals( "SchoolDonations"))
        	service = new SchoolDonations();
        else if(provider.equals( "CancerHospitalDonations"))
            service = new CancerHospitalDonations();
        else if(provider.equals( "MonthlyReceipt"))
        	service = new MonthlyReceipt();
        else if(provider.equals( "QuarterReceipt"))
        	service = new QuarterReceipt();
		else
			return null;
		return service;
	}
}
