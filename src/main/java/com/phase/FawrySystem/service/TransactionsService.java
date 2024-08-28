package com.phase.FawrySystem.service;

import java.util.Vector;
import com.phase.FawrySystem.models.Transaction;
import static com.phase.FawrySystem.database.DataBase.transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService 
{
	public Vector<Transaction> ViewTransactions()
	{
		if(transaction.size() != 0)
			return transaction;
		return null;
	}
}
