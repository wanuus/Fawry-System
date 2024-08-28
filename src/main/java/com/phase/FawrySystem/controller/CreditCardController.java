package com.phase.FawrySystem.controller;

import static com.phase.FawrySystem.database.DataBase.UsersData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phase.FawrySystem.models.CreditCard;
import com.phase.FawrySystem.service.CreditCardService;

@RestController
@RequestMapping("/CreditCardController")
public class CreditCardController 
{
	
	@Autowired
	CreditCardService creditcardserv = new CreditCardService();
	@PostMapping("/AddCreditCard")
	public ResponseEntity<String> AddCreditCard(@RequestBody CreditCard c)
	{
		if(creditcardserv.addCreditCard(c))
		{
			return ResponseEntity.ok("Credit Card Added Successfully");
		}
		return ResponseEntity.ok("Unable to Add Credit Card");
	}
	
	
	

}
