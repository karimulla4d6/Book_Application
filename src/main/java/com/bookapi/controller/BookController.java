package com.bookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.model.Book;
import com.bookapi.service.BookService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@DeleteMapping(path = "/book/{id}")
	private ResponseEntity<String> deleteBook(@PathVariable int id) {
		return ResponseEntity.ok().body(bookService.deleteBook(id));
	}
	
	
	@PutMapping(path = "/book/{id}")
	private ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book book) {
		Book books = bookService.updateBook(id, book);
		return ResponseEntity.ok().body(books);
	}

	@GetMapping("/book/{id}")
	private ResponseEntity<Book> getBook(@PathVariable int id){		
		return ResponseEntity.ok().body(bookService.getBook(id));
	}
	
	@GetMapping("/book")
	private ResponseEntity<List<Book>> getAllBook(){
		List<Book> listOfBook = bookService.getAllBook();
		System.out.println("Hello");
		return ResponseEntity.ok().body(listOfBook);
	}
	
	@PostMapping(path = "/book")
	private ResponseEntity<Book> saveBook(@RequestBody Book book) {
		Book savedBook = bookService.saveBook(book);
		return ResponseEntity.ok().body(savedBook);
	}
}
