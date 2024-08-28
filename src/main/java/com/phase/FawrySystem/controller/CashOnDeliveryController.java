package com.phase.FawrySystem.controller;

import static com.phase.FawrySystem.database.DataBase.UsersData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phase.FawrySystem.service.CashOnDeliveryService;
import com.phase.FawrySystem.models.CashOnDelivery;

@RestController
@RequestMapping("/CashOnDeliveryController")

public class CashOnDeliveryController {
	@Autowired
	CashOnDeliveryService CashDelivery = new CashOnDeliveryService();
	@PostMapping("/Paymethod")
	public ResponseEntity<String> paymethod(@RequestBody CashOnDelivery ca4)
	{
		if(CashDelivery.payMethod(ca4))
		{
			return ResponseEntity.ok("Deliverd Successfully");
		}
		return ResponseEntity.ok("Unable to Deliverd");
	}
	

}
