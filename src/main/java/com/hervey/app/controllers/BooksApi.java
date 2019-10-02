package com.hervey.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hervey.app.models.Book;
import com.hervey.app.services.BookService;

@RestController

	
public class BooksApi {
	private final BookService bookService;
	public BooksApi(BookService bookService) {
		this.bookService=bookService;
	}
	
	
	@RequestMapping("api/books")
	public List<Book> index(){
		System.out.println("bug");
		List<Book> allBooks = bookService.allBooks();
		System.out.println(allBooks.size());
		return bookService.allBooks();
		
	}
	
	
	@GetMapping("api/books/{id}")
	public Book returnBook(@PathVariable("id") Long bookId) {
		Book book= bookService.findBook(bookId);
		return book;
	}
	
	@PostMapping("api/books")
	public Book createBook(@ModelAttribute("book") Book book) {
		System.out.println("Creating Book to save book named:  "+ book.getTitle());
		
		bookService.saveBook(book);
		return book;
	}
	
	
/*
 * The above createBook uses @ModelAttribute to retrieve the book information then uses bookService.saveBook() with bookService using bookRepository.save(book);
 * 
 * However, there is another way:  Grab the information from the post using @RequestParam and a contructor that accepts the three arguments
 * 
 *     public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }

 *     public Book createBook(Book b) {
        return bookRepository.save(b);
    }

 * 
 * 
 * 
 * 
 * 
 */
	
	
	
	
	@PutMapping("api/books/{id}")
	public Book updateBook(@ModelAttribute("book") Book book, @PathVariable("id") Long bookId) {
		System.out.println("in Put ");
		
		bookService.saveBook(book);
		return book;
	}
	
	@DeleteMapping("api/books/{id}")
	public void deleteBook(@ModelAttribute("book") Book book) {
		
		bookService.deleteBook(book);
	}
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	

