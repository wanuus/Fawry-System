package com.phase.FawrySystem.service;

import static com.phase.FawrySystem.database.DataBase.UsersData;

import static com.phase.FawrySystem.database.DataBase.OverAll;
import static com.phase.FawrySystem.database.DataBase.Specific;
import static com.phase.FawrySystem.database.DataBase.active;
import static com.phase.FawrySystem.database.DataBase.on;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.springframework.stereotype.Service;
import com.phase.FawrySystem.models.Discount;
import com.phase.FawrySystem.models.OverallDiscount;
import com.phase.FawrySystem.models.ServiceProviderFactory;
import com.phase.FawrySystem.models.SpecificDiscount;
import com.phase.FawrySystem.models.User;
@Service
public class DiscountService {


	public boolean AddOverallDiscount( OverallDiscount d)
	{
		try 
        {
            if(on==true)
               {
                if(d.getDiscount()>0)
            		 {
                	
            			 
            			 OverAll.add(0,d);
            			 return true;
            		 }
        
               }
            
        } catch (Exception e) 
        {
        	 return false;
        }
        return false;
        
	}
	public boolean AddSpecificDiscount( SpecificDiscount d)
	{
		ServiceProviderFactory providerFac = new ServiceProviderFactory();
		String serv =d.getService();
		
		try 
        {
            if(on==true)
               {
                if(d.getDiscount()>0 &&(providerFac.ProviderCreator(serv)!=null))
            		 {
            			 
                	  Specific.add(d);
            			 return true;
            		 }
                 
               }
            
        } catch (Exception e) 
        {
        	 return false;
        }
        return false;
        
	}
	public Map<String, Discount> viewDiscount() {
		int c=0;
		
		 Map<String, Discount > Discounts = new HashMap();
		try 
        {
             if(active.getEmail() != null)
               {
                if(Specific.size()>0)
            		 {
                	for(int i=0;i<Specific.size();i++) {
                		Discounts.put("SpecificDiscount"+c++, Specific.get(i));
                		
                	}
            			 
            		
            		 }
                 if(OverAll.size()>0)
       		     {
                	 for(int i=0;i<OverAll.size();i++) {
                 		Discounts.put("OverAllSpecificDiscount"+c++, OverAll.get(i));
                 	}
             			
       	     	 }
                 
                 
               }
             return Discounts;
            
        } catch (Exception e) 
        {
        	 return Discounts;
        }
		
		
	}
	
}
