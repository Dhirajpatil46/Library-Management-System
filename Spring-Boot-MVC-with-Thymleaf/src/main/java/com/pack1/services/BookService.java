package com.pack1.services;

import com.pack1.entity.Books;

public interface BookService 
{
	public boolean AddBook(Books book);
	public void saveBook(Books book);
	public void deleteBookById(String bookId);
}
