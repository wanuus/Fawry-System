package com.phase.FawrySystem.service;
import static com.phase.FawrySystem.database.DataBase.RefundReqs;
import static com.phase.FawrySystem.database.DataBase.on;
import static com.phase.FawrySystem.database.DataBase.UsersData;
import static com.phase.FawrySystem.database.DataBase.active;
import java.util.Vector;
import org.springframework.stereotype.Service;
import com.phase.FawrySystem.models.Refund;
@Service
public class RefundService 
{
	public String RequestRefund(Refund r)
	{
		if(active == null)
			return "Please SignIn";
		r.setEmail(active.getEmail());
		r.setState("Pending");
		r.setID(RefundReqs.size()+1);
		RefundReqs.add(r);
		return "Refund Request is now Pending to be reviewed";
	}
	public Vector<Refund> ViewRequest()
	{
		return RefundReqs;
	}
	public String HandelRefund(int id,String status)
	{
		if(on == false)
			return "Please SignIn";
		for(int i=0;i<RefundReqs.size();i++)
		{
			if(RefundReqs.get(i).getID() == id)
			{
				RefundReqs.get(i).setState(status);
				if(status.equals("Approve")&&(UsersData.get(RefundReqs.get(i).getEmail())!=null)) 
				{
					UsersData.get(RefundReqs.get(i).getEmail()).getWallet().setAmount(RefundReqs.get(i).getAmount());;
					
				}
				
			}
			
		}
		
		return "Refund is reviewed";
	}
	
}
