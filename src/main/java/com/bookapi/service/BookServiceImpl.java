package com.bookapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapi.dao.BookRepo;
import com.bookapi.model.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> getAllBook() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBook(int id) {
		Optional<Book> option = bookRepo.findById(id);
		return option.get();
	}

	@Override
	public Book updateBook(int id,Book book) {
		Optional<Book> option = bookRepo.findById(id);
		Book gotBookData = option.get();
		gotBookData.setAuthor(book.getAuthor());
		gotBookData.setBookName(book.getBookName());
		gotBookData.setPrice(book.getPrice());
		bookRepo.save(gotBookData);
		Optional<Book> option1 = bookRepo.findById(id);
		return option1.get();
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	
	@Override
	public String deleteBook(int id) {
		bookRepo.deleteById(id);
		return "Record Deleted ==> "+id;
	}

}
