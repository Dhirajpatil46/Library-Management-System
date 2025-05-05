package com.pack1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack1.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> 
{  
	User findByMail(String mail);
}
