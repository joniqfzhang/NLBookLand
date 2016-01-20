package com.nlbookland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nlbookland.model.Book;
import com.nlbookland.service.BookService;

@Controller
public class BookListController {
	String message = "Book List";
	@Autowired    
	private BookService bookService;
	
	@RequestMapping(value="/booklist")
	public ModelAndView showBookList(){
		System.out.println("in booklist controller");
		ModelAndView mv = new ModelAndView("booklist");
		
		List<Book> booklist = bookService.getBookList();
		
		mv.addObject("booklist", booklist);
		mv.addObject("book", new Book());
		mv.addObject("message", message);
		
		return mv;
		
	}
}
