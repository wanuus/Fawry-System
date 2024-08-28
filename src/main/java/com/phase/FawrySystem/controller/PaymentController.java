package com.phase.FawrySystem.controller;

import java.util.Map;
import static com.phase.FawrySystem.database.DataBase.active;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phase.FawrySystem.service.PaymentService;

@RestController
@RequestMapping("/PaymentController")
public class PaymentController 
{
	@Autowired
	PaymentService paymentServ = new PaymentService();
	@PostMapping("/Pay")
	public ResponseEntity<String> Pay(@RequestBody Map<String,Object> mp)
	{
		if(active.getEmail() == null)
			return ResponseEntity.ok("Please SignIn");
		return ResponseEntity.ok(paymentServ.Pay(mp));
	}
}
