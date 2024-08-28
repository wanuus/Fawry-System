package com.phase.FawrySystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static com.phase.FawrySystem.database.DataBase.on;
import static com.phase.FawrySystem.database.DataBase.active;
import org.springframework.web.bind.annotation.RestController;
import com.phase.FawrySystem.service.AdminService;
import com.phase.FawrySystem.service.UserService;
@RestController
@RequestMapping("/AdminController")
public class AdminController 
{
	@Autowired
	 AdminService adminservice = new AdminService();
	@GetMapping("/signin")
	 public ResponseEntity<String> signin(@RequestParam ("password") String password)
	 {
		 if(adminservice.Signin(password))
		 {
			 active=null;
			 on=true;
			 return ResponseEntity.ok("Signed In Successfully");
		 }
		 return ResponseEntity.ok("Wrong Password");
		 
	 }
	@PostMapping("/signout")
	 public ResponseEntity<String> signout(@RequestParam ("exit") String out)
	 {
		 if(adminservice.Signout(out))
		 {
			 on=false;
			 return ResponseEntity.ok("Signed out Successfully");
		 }
		 return ResponseEntity.ok("Failed to Sign out");
		 
	 }
}
