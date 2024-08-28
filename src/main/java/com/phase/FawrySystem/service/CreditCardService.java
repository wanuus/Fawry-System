package com.phase.FawrySystem.service;
import static com.phase.FawrySystem.database.DataBase.Payments;
import static com.phase.FawrySystem.database.DataBase.Paymentt;
import static com.phase.FawrySystem.database.DataBase.UsersData;
import static com.phase.FawrySystem.database.DataBase.active;
import com.phase.FawrySystem.models.Payment;
import org.springframework.stereotype.Service;
import com.phase.FawrySystem.models.CreditCard;
import com.phase.FawrySystem.models.User;
@Service
public class CreditCardService 
{

	public boolean addCreditCard(CreditCard c)
	{
		try 
        {
            if(active.getEmail() != null)
            {
            	active.setCreditCard(c);
            	UsersData.put(active.getEmail(),active);
            	return true;
            }
        } catch (Exception e) 
        {
        	 return false;
        }
        return false;
        
	}
	
}
