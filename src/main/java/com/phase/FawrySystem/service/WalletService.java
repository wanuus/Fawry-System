package com.phase.FawrySystem.service;
import static com.phase.FawrySystem.database.DataBase.Payments;
import static com.phase.FawrySystem.database.DataBase.Paymentt;
import static com.phase.FawrySystem.database.DataBase.UsersData;
import static com.phase.FawrySystem.database.DataBase.active;
import org.springframework.stereotype.Service;
import com.phase.FawrySystem.models.CreditCard;
import com.phase.FawrySystem.models.Wallet;
@Service
public class WalletService {
	
	
	public boolean AddWallet( Wallet w)
	{
		try 
        {
            	 if(active.getEmail() != null)
                 {
            		
            		 if(UsersData.get(active.getEmail()).getCreditCard().GetavalAmount() >= w.GetavalAmount())
            		 {
            			 
            			 UsersData.put(active.getEmail(),active);
            			 UsersData.get(active.getEmail()).setWallet(w);
            			 UsersData.get(active.getEmail()).getCreditCard().setAvalAmount(UsersData.get(active.getEmail()).getCreditCard().GetavalAmount()-w.GetavalAmount());
            			

            			 return true;
            			 
            		 }
            		
                 
                 }
          
            
        } catch (Exception e) 
        {
        	 return false;
        }
        return false;
        
	}
	
	

}