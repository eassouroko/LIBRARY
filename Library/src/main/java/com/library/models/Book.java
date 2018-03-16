package com.library.models;

import java.io.Serializable;
import java.util.ArrayList;
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
	@Id
	@GeneratedValue
	private long idBook;
	
	private String title;
	@ManyToMany( mappedBy = "books")
	private List<Author> authors= new ArrayList<Author>();

	public Book() {
		super();
	}
	

	public Book(String title) {
		super();
		this.title = title;
		
		
		//this.publicationDate = publicationDate;
	}

	

	
	public String getTitel() {
		return title;
	}

	
	public List<Author> getAuthors() {
		return authors;
	}
	

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + idBook + ", title=" + title + ", authors=" + authors + "]";
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
		result = prime * result + (int) (idBook ^ (idBook >>> 32));
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
		if (idBook != other.idBook) {
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


	public long getIdBook() {
		return idBook;
	}


	public void setIdBook(long idBook) {
		this.idBook = idBook;
	}


	/*	@Override
		public int compareTo(Object anotherBook) throws ClassCastException {
		    if (!(anotherBook instanceof Book))
		      throw new ClassCastException("A Book object expected.");
		    //int anotherPersonAge = ((Person) anotherPerson).getAge();  
		    return this.hashCode() - anotherBook.hashCode();    
		  }*/

}
