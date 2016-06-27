package com.nlbookland.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlbookland.model.Book;
import com.nlbookland.service.BookService;

@Controller
public class BookListController {
	private static final Logger logger = LoggerFactory.getLogger(BookListController.class);
	String message = "Book List";
	@Autowired    
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET, value="/booklist")
	public ModelAndView showBookList(){
		//System.out.println("in booklist controller");
		logger.info("Entered booklist controller - showBookList");
		ModelAndView mv = new ModelAndView("booklist");
		
		List<Book> booklist = getBookList();
		
		mv.addObject("booklist", booklist);
		mv.addObject("book", new Book());
		mv.addObject("booklist_message", message);
		
		return mv;		
	}
	
	private List<Book> getBookList() {
		List<Book> list = bookService.getBookList();
		logger.info("Retrived " + list.size() + " books.");
		return list;
	}
}
