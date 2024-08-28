package com.phase.FawrySystem.controller;
import com.phase.FawrySystem.models.User;
import com.phase.FawrySystem.service.UserService;

import static com.phase.FawrySystem.database.DataBase.active;

import java.util.Map;
import java.util.Vector;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/UserController")
public class UserController 
{
	 @Autowired
	 UserService usersService = new UserService();
	 @PostMapping("/signup")
	 public ResponseEntity<String> signup(@RequestBody User u) 
	 {
	        boolean res = usersService.SignUp(u);
	        if (!res) 
	        {
	           return ResponseEntity.ok("Email Already Used");
	            
	        }
	        return ResponseEntity.ok("Signed up Successfully ");
	 }
	 @GetMapping("/signin")
	 public ResponseEntity<String> signin(@RequestParam ("email") String email,@RequestParam ("password") String password)
	 {
		 if(usersService.SignIn(email, password))
		 {
			 return ResponseEntity.ok("Signed In Successfully");
		 }
		 return ResponseEntity.ok("Wrong Email or Password");
		 
	 }
	 @PostMapping("/signout")
	 public ResponseEntity<String> signout(@RequestParam ("exit") String out)
	 {
		 if(usersService.Signout(out))
		 {
			 active=null;
			 return ResponseEntity.ok("Signed out Successfully");
		 }
		 return ResponseEntity.ok("Failed to Sign out");
		 
	 }
	 @GetMapping("/Search")
	 public ResponseEntity<Vector<String>> Search(@RequestParam ("Search") String sequence )
	 {
		 Vector <String> fail = new Vector();
		 fail.add("Failed, Please Sign In First");
		 if(  active != null)
		 {
			 return ResponseEntity.ok(usersService.Search(sequence));
		 }
		 return ResponseEntity.ok(fail);
		 
	 }
}