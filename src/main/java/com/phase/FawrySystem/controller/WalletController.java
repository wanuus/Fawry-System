package com.phase.FawrySystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.phase.FawrySystem.models.Wallet;
import com.phase.FawrySystem.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/WalletController")
public class WalletController
{	
	@Autowired
	WalletService walletService = new WalletService();
	@PostMapping("/AddWallet")
	public ResponseEntity<String> AddWallet(@RequestBody Wallet w)
	{
		
		if(walletService.AddWallet(w))
		{
			return ResponseEntity.ok("Wallet Added Successfully");
		}
		return ResponseEntity.ok("Unable to Add Wallet");
	}

}
 