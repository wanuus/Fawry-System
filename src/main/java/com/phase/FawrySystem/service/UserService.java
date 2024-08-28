package com.phase.FawrySystem.service;
import static com.phase.FawrySystem.database.DataBase.UsersData;
import static com.phase.FawrySystem.database.DataBase.on;
import static com.phase.FawrySystem.database.DataBase.active;
import java.util.Map;
import java.util.Vector;
import java.util.ArrayList;
import com.phase.FawrySystem.models.*;

import org.springframework.stereotype.Service;
@Service
public class UserService 
{
	public boolean SignUp(User u)
	{
		try 
		{
            if (UsersData.get(u.getEmail()) != null) 
            {
                return false;
            }
            UsersData.put(u.getEmail(), u);
        } 
		catch (Exception e) 
		{
            return false;
        }
        return true;
	}
	public boolean SignIn(String email,String password) 
	{
        try 
        {
            if(UsersData.get(email).getPassword().equals(password))
            {
            	on=false;
            	active = UsersData.get(email);
            	return true;
            }
        } catch (Exception e) 
        {
        	return false;
        }
        return false;
    }
	public boolean Signout(String exit)
	{
		return(exit.equals("Signout"));
	}
	public Vector<String> Search(String sequence)
	{
		Vector <String> providers = new Vector();
		Vector <String> found = new Vector();
		
		providers.add("Vodafone Mobile Recharge");
		providers.add("Vodafone Internet");
		providers.add("We Mobile Recharge");
		providers.add("We Internet");
		providers.add("Orange Mobile Recharge");
		providers.add("Orange Internet");
		providers.add("Etisalat Mobile Recharge ");
		providers.add("Etisalat Internet");
		providers.add("NGOsDonations");
		providers.add("SchoolDonations");
		providers.add("CancerHospitalDonations");
		providers.add("MonthlyReceipt");
		providers.add("QuarterReceipt");
		
		try 
        {
          
		for (int i = 0 ; i < 12 ; i++)
		{
			if (providers.get(i).contains(sequence))
			{
				found.add (providers.get(i)) ;
			}
		}
		if (found.size()<1)
		{
			found.add("None");
		}
		
        }
		 catch (Exception e) 
        {
           return null;
        }
		return found ;
	}		
}