package io.github.anantharajuc.sbmwa.service;

import java.util.List;

import io.github.anantharajuc.sbmwa.domain.model.Books;

public interface BookService 
{
	List<Books> findAllBooks();
	
	Books findBookById(Long id);
}
