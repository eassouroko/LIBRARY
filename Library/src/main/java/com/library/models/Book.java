package com.library.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity(name="Book")
@Table(name="book")
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//Wannt to try with ISBN
	
//	@GeneratedValue
//	private long idBook;
	
	@Id
	private long isbnBook;
	private Date publicationDate;
	private Long quantity;
	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	private String title;
	@ManyToMany( mappedBy = "books")
	private java.util.Set<Author> authors= new HashSet<Author>();

	public Book() {
		super();
	}
	

	public Book(long isbn,String title, Date date) {
		super();
		this.isbnBook=isbn;
		this.title = title;
		
		
		this.publicationDate = date;
	}

	

	
	public String getTitel() {
		return title;
	}

	
	public java.util.Set<Author> getAuthors() {
		return authors;
	}
	

	public void setAuthors(HashSet<Author> authors) {
		this.authors = authors;
	}


	public Date getPublicationDate() {
		return publicationDate;
	}


	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + isbnBook + ", title=" + title + ", authors=" + authors + "]";
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + (int) (isbnBook ^ (isbnBook >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null) {
				return false;
			}
		} else if (!authors.equals(other.authors)) {
			return false;
		}
		if (isbnBook != other.isbnBook) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}


	public long getIsbnBook() {
		return isbnBook;
	}


	public void setIsbnBook(long isbnBook) {
		this.isbnBook = isbnBook;
	}


//	public long getIdBook() {
//		return idBook;
//	}
//
//
//	public void setIdBook(long idBook) {
//		this.idBook = idBook;
//	}


	/*	@Override
		public int compareTo(Object anotherBook) throws ClassCastException {
		    if (!(anotherBook instanceof Book))
		      throw new ClassCastException("A Book object expected.");
		    //int anotherPersonAge = ((Person) anotherPerson).getAge();  
		    return this.hashCode() - anotherBook.hashCode();    
		  }*/

}
