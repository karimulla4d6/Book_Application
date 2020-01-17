package com.bookapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookapi.dao.BookRepo;
import com.bookapi.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceImplTest {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	@MockBean
	private BookRepo bookRepo;

	@Test
	public void testGetAllBook() {
		Book book1 = new Book();
		book1.setAuthor("karimulla");book1.setBookId(1);
		book1.setBookName("java");book1.setPrice("200.00");
		Book book2 = new Book(); book2.setAuthor("Subhani"); book2.setBookId(2); book2.setBookName("c lang"); book2.setPrice("300.00");
		List<Book> list = Arrays.asList(book1,book2);
		when(bookRepo.findAll()).thenReturn(list);
		list = bookServiceImpl.getAllBook();
		assertEquals(2, list.size());
		verify(bookRepo).findAll();
	}
	
	@Test
	public void getBookByIdTest() {
		Book book1 = new Book();
		book1.setAuthor("karimulla");book1.setBookId(1);book1.setBookName("java");book1.setPrice("1000.00");
		when(bookRepo.findById(1)).thenReturn(Optional.of(book1));
		Book book2 = bookServiceImpl.getBook(1);
		assertEquals("java", book2.getBookName());
	}
	
	

}
