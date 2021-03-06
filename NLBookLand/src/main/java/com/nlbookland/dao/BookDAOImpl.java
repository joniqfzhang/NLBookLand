package com.nlbookland.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nlbookland.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBooks() {
		Session session = this.sessionFactory.openSession();
		List<Book> bookList = session.createQuery("from Book").list();
        /*for(Book b : bookList){
        	System.out.println(b);            
        }*/
        logger.info("Retrived " + bookList.size() + " books.");
		return bookList;
	}

}
