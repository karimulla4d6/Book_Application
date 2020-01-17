package com.bookapi.service;

import java.util.List;

import com.bookapi.model.Book;

public interface BookService {
	public List<Book> getAllBook();
	public Book getBook(int id);
	public Book updateBook(int id,Book book);
	public Book saveBook(Book book);
	public String deleteBook(int id);
}
