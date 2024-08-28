package com.phase.FawrySystem.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phase.FawrySystem.models.Discount;
import com.phase.FawrySystem.models.OverallDiscount;
import com.phase.FawrySystem.models.SpecificDiscount;
import com.phase.FawrySystem.service.DiscountService;

@RestController
@RequestMapping("/DiscountController")
public class DiscountController {

	@Autowired
	DiscountService DiscountService = new DiscountService();
	@PostMapping("/AddOverAllDiscount")
	public ResponseEntity<String> AddOverAllDiscount(@RequestBody OverallDiscount o)
	{
		
		if(DiscountService.AddOverallDiscount(o))
		{
			return ResponseEntity.ok("Discount Added Successfully");
		}
		return ResponseEntity.ok("Unable to Add Discount");
	}
	@PostMapping("/AddSpecificDiscount")
	public ResponseEntity<String> AddSpecificDiscount(@RequestBody SpecificDiscount s)
	{
		
		if(DiscountService.AddSpecificDiscount(s))
		{
			return ResponseEntity.ok("Discount Added Successfully");
		}
		return ResponseEntity.ok("Unable to Add Discount");
	}
	@GetMapping("/VeiwDiscounts")
	public ResponseEntity<Map<String,Discount>> AddSpecificDiscount()
	{
		return ResponseEntity.ok(DiscountService.viewDiscount());
	}
	

}
