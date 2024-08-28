package com.phase.FawrySystem.service;

import static com.phase.FawrySystem.database.DataBase.UsersData;
import static com.phase.FawrySystem.database.DataBase.Payments;
import static com.phase.FawrySystem.database.DataBase.Paymentt;
import static com.phase.FawrySystem.database.DataBase.active;

import org.springframework.stereotype.Service;

import com.phase.FawrySystem.models.CashOnDelivery;
import com.phase.FawrySystem.models.CreditCard;
@Service
public class CashOnDeliveryService {
	public boolean payMethod(CashOnDelivery cash)
	{
		try 
        {
            if(active.getEmail() != null)
            {
           
            	UsersData.put(active.getEmail(),active);
            	Paymentt.add(cash);
            	Payments.put(active.getEmail(), Paymentt);
            	System.out.println(Paymentt);
            	System.out.println(Payments);
            	
            	return true;
            }
        } catch (Exception e) 
        {
        	 return false;
        }
        return false;
        
	}

}
