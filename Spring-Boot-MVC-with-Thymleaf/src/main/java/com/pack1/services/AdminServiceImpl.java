package com.pack1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack1.entity.Admin1;
import com.pack1.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	private AdminRepository ar;

	@Override
	public Admin1 LoginAdmin(String email, String Password) 
	{
		Admin1 admin1 = ar.findByAemail(email);
		if(admin1 != null && admin1.getPassword().equals(Password))
		{
			return admin1; 
		}
		return null;
	}

}
