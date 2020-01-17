package com.bookapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookapi.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
