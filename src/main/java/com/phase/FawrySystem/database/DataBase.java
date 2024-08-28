package com.phase.FawrySystem.database;
import java.io.*;
import java.util.*;

import com.phase.FawrySystem.models.Admin;
import com.phase.FawrySystem.models.Discount;
import com.phase.FawrySystem.models.OverallDiscount;
import com.phase.FawrySystem.models.SpecificDiscount;
import com.phase.FawrySystem.models.Payment;
import com.phase.FawrySystem.models.Refund;
import com.phase.FawrySystem.models.Transaction;
import com.phase.FawrySystem.models.User;
public abstract class DataBase
{

	public static  User active;
	public static boolean on;
	public static  Vector<Payment> Paymentt = new Vector<Payment>();
	public static  Vector<Transaction> transaction = new Vector<Transaction>();
	public static  Map<String, User> UsersData = new HashMap();
	public static  Vector<OverallDiscount> OverAll = new Vector<OverallDiscount>();
	public static  Vector<SpecificDiscount> Specific = new Vector<SpecificDiscount>();
	public static  Map< String,Vector<Payment>> Payments = new HashMap();
	public static  Vector<Refund> RefundReqs = new Vector<Refund>();
	
}
