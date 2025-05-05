package com.pack1.services;

import java.util.List;
import com.pack1.entity.Books;
import com.pack1.entity.User;

public interface UserService 
{
	public boolean RegisterUser(User user);
	public User LoginUser(String email, String Password);
	public List<Books> getAllBooks();
	public Books getBookById(String bookId);
	public void saveBook(Books books);

}
