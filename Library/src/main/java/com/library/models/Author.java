package com.library.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="Author")
@Table(name = "author")
public class Author implements Serializable, Comparable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long idAuthor;
	private String name;
	//@Column(unique = true)
	private String email;
	
	
	public Author() {
		super();
	}

	public Author(String name, String mail) {
		super();
		this.name = name;

		this.email = mail;

	}

	

	public long getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(long idAuthor) {
		this.idAuthor = idAuthor;
	}

	@ManyToMany(cascade =  CascadeType.ALL,targetEntity=com.library.models.Book.class)
	@JoinTable(name = "author_book", joinColumns = { @JoinColumn(name = "idAuthor") }, inverseJoinColumns = {
			@JoinColumn(name = "isbnBook") })
	private java.util.Set<Book> books= new HashSet<Book>();
	//private List<Book> books= new ArrayList<Book>();

	public java.util.Set<Book> getBooks() {
		return books;
	}

	public void setBooks(HashSet<Book> books) {
		this.books = books;
	}

	
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idAuthor ^ (idAuthor >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Author)) {
			return false;
		}
		Author other = (Author) obj;
		if (books == null) {
			if (other.books != null) {
				return false;
			}
		} else if (!books.equals(other.books)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (idAuthor != other.idAuthor) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author [name=" + name + ", email=" + email + ", books=" + books + "]";
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated
		
		int value=-1;
		if (!(obj instanceof Author)||obj==null) {
			return value;
		}else {
			Author writer= (Author)obj;
			value= this.email.hashCode()-writer.email.hashCode();
		}
		
		return value;
	}


}
