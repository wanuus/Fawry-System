package com.phase.FawrySystem.service;
import org.springframework.stereotype.Service;
import com.phase.FawrySystem.models.Admin;

@Service
public class AdminService 
{
	public boolean Signin(String pass)
	{
		return(pass.equals(Admin.getPassword()));
	}
	public boolean Signout(String exit)
	{
		return(exit.equals("Signout"));
	}

}
