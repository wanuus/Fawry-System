package com.phase.FawrySystem.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phase.FawrySystem.models.Transaction;
import com.phase.FawrySystem.service.TransactionsService;

@RestController
@RequestMapping("/Transactions")
public class TransactionsController 
{
	@Autowired
	TransactionsService service = new TransactionsService();
	@GetMapping("/View")
	public ResponseEntity<Vector<Transaction>> ViewReq()
	{
		try
		{
			return ResponseEntity.ok(service.ViewTransactions());
		}catch(Exception e)
		{
			return (ResponseEntity<Vector<Transaction>>) ResponseEntity.badRequest();
		}
		
	}
}
