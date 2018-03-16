package com.library.services;



//import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.library.models.Book;

@Repository

public interface BookRepository extends JpaRepository<Book,Long>{
	


}
