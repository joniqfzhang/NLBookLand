package com.nlbookland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nlbookland.dao.BookDAO;
import com.nlbookland.model.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired 
	private BookDAO bookDAO;
	
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	@Transactional
	public List<Book> getBookList() {
		return this.bookDAO.listBooks();
	}
	
}
