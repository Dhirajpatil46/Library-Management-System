package com.pack1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack1.entity.Admin1;

public interface AdminRepository extends JpaRepository<Admin1, Integer> 
{
	Admin1 findByAemail(String aemail);

}
