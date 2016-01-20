package com.nlbookland.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {	
    private int id;
    private String title;
	private String author;
    private String isbn;
    private Set<Person> persons; 
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id") 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="person_book", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="person_id"))  
	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
	public String toString(){
		return this.id + " " + this.title + " " + this.author + " " +this.isbn ;
		
	}
	
}