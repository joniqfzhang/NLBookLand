package com.nlbookland.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nlbookland.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBooks() {
		Session session = this.sessionFactory.openSession();
		List<Book> bookList = session.createQuery("from Book").list();
        for(Book b : bookList){
        	System.out.println(b);            
        }
        
		return bookList;
	}

}
