package com.pack1.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack1.entity.Admin1;
import com.pack1.entity.Books;
import com.pack1.entity.User;
import com.pack1.repository.AdminRepository;
import com.pack1.repository.BookRepository;
import com.pack1.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private BookRepository br;
	
	@Override
	public boolean RegisterUser(User user) 
	{
		try 
		{
			ur.save(user);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User LoginUser(String email, String Password) 
	{
		User user = ur.findByMail(email);
		if(user != null && user.getPassword().equals(Password))
		{
			return user; 
		}
		return null;
	}

	@Override
	public List<Books> getAllBooks() 
	{
		return br.findAll();
	}
	
	@Override
	public Books getBookById(String bookId) {
	    return br.findById(bookId).orElse(null);
	}

	@Override
	public void saveBook(Books book) 
	{
        br.save(book);
    }

}
