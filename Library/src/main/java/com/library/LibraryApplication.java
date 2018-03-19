package com.library;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.library.models.Author;
import com.library.models.Book;
import com.library.services.AuthorRepository;
import com.library.services.BookRepository;

@SpringBootApplication
@EnableJpaRepositories("com.library.services")
@ComponentScan("com.library.services")
public class LibraryApplication implements CommandLineRunner{

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Author author1= new Author("Markus Garvey","mgarvey@hotmail.com");
		Author author2= new Author ("Hans-Jürgen Massaquoi","hj@gmail.com");
		Book b1=  new Book(1112223111117L,"My Kindheit in Deutschland", java.sql.Date.valueOf("2009-03-01"));
		b1.getAuthors().add(author1);
		b1.getAuthors().add(author2);
		bookRepository.save(b1);
		
		//Book book1= new Book(1112223111132L,"My Way", java.sql.Date.valueOf("2017-03-01"));
		//book1.setQuantity(new Long(100));
		//author1.getBooks().add(book1);
		//java.util.ArrayList<Author> existing=(ArrayList<Author>) authorRepository.findAll();
		
		//authorRepository.save(author1);
		
		
		
		
		
		
		
	}
}
