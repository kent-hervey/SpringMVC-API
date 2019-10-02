package com.hervey.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hervey.app.models.Book;
import com.hervey.app.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
		
	}
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book findBook(Long id) {
		Optional <Book> book=bookRepository.findById(id);
		if(book.isPresent()) {
			return book.get();
		}
		else {
			return null;
			
		}
		
	}

	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
		
	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.delete(book);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
