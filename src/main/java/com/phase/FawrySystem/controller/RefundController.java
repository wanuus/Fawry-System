package com.phase.FawrySystem.controller;
import java.util.Vector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.phase.FawrySystem.models.Refund;
import com.phase.FawrySystem.models.User;
import com.phase.FawrySystem.service.RefundService;
@RestController
@RequestMapping("/RefundController")
public class RefundController 
{
	@Autowired
	RefundService refunds = new RefundService();
	@PostMapping("/request")
	public ResponseEntity<String> RequestRefund(@RequestBody Refund r)
	{
		return ResponseEntity.ok (refunds.RequestRefund(r));
	}
	@GetMapping("/ViewReq")
	public ResponseEntity<Vector<Refund>> ViewReq()
	{
		return ResponseEntity.ok(refunds.ViewRequest());
	}
	 @GetMapping("/HandelRefund")
	 public ResponseEntity<String> handelrefund(@RequestParam ("Id") int id,@RequestParam ("status") String state)
	 {
			 return ResponseEntity.ok(refunds.HandelRefund(id, state)); 
	 }
}
