package com.pack1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack1.entity.Books;
import com.pack1.repository.BookRepository;

@Service
public class BooksServiceImpl implements BookService 
{
	@Autowired
	private BookRepository br; 

	@Override
	public boolean AddBook(Books book) 
	{
		try 
		{
			br.save(book);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void saveBook(Books book) 
	{
		br.save(book);
	}

	@Override
	public void deleteBookById(String bookId) 
	{
		br.deleteById(bookId);
		
	}

}
