package com.phase.FawrySystem.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import static com.phase.FawrySystem.database.DataBase.active;
import static com.phase.FawrySystem.database.DataBase.Specific;
import static com.phase.FawrySystem.database.DataBase.OverAll;

import static com.phase.FawrySystem.database.DataBase.transaction;
import com.phase.FawrySystem.models.CashOnDelivery;
import com.phase.FawrySystem.models.CreditCard;
import com.phase.FawrySystem.models.Payment;
import com.phase.FawrySystem.models.PaymentTransaction;
import com.phase.FawrySystem.models.ServiceProviderFactory;
import com.phase.FawrySystem.models.SpecificDiscount;
import com.phase.FawrySystem.models.Transaction;
import com.phase.FawrySystem.models.Wallet;

@Service
public class PaymentService 
{
	
	public int getDiscount(String prov)
	{
		int discount=0;
		for(int i=0;i<Specific.size();i++) 
		{
		if((Specific.get(i).getService().equals(prov))&&(Specific.get(i).getDiscount()>discount))
		{
			discount= Specific.get(i).getDiscount();
		}}
		if(OverAll.size()>0) {
		discount+=OverAll.get(0).getDiscount();
		}
	return discount;
	}
	
	
	public String Pay(Map<String,Object> mp)
	{
		
		if(mp.get("method") == null)
			return "Please Enter the Method Used to Pay";
		if(mp.get("provider") == null)
			return "Please Enter Service Provider";
		ServiceProviderFactory providerFac = new ServiceProviderFactory();
		String provider = (String) mp.get("provider");
		try {
		if(!providerFac.ProviderCreator(provider).Handler(mp))
			return "payment failed, PLease enter correct information";
		}catch(Exception e)
		{
			return "Payment failed, No such Provider";
		}
		
		int amount = (int) mp.get("amount");
		String method = (String) mp.get("method");
		Payment payway;
		int discount =getDiscount(provider);
	
		if(method.equals("wallet"))
			payway = active.getWallet();
		else
			payway = active.getCreditCard();
		
		if(payway.GetavalAmount() < amount)
			return "No Available Credit";
		payway.Process(amount,discount);
	
		PaymentTransaction Transac = new PaymentTransaction();
		Transac.setEmail(active.getEmail());
		Transac.setServiceprovID(provider);
		Transac.setAmount(amount);
		transaction.add(Transac);
		return "Paid Successfully";
	}
}
