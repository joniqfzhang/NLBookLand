package com.nlbookland.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nlbookland.model.Book;
import com.nlbookland.model.Person;
import com.nlbookland.service.PersonService;

@Controller
public class PersonListController {
	String message = "Please Click Buttons to Book List And Person List";
	String rootmessage = "Welcome to BookLand!!!";
	@Autowired    
	private PersonService personService;
	 
	@RequestMapping(value="/personlist")
	public ModelAndView showPersonlist() {
		System.out.println("in personlist controller");
		
		List<Person> personlist = getPersonList();
		//List<String> personlist = getPersonList();
 
		ModelAndView mv = new ModelAndView("personlist");
		mv.addObject("personlist", personlist);
		mv.addObject("person", new Person());
		mv.addObject("message", message);
		
		return mv;
	}
	
	@RequestMapping(value="/personbooks")
	@ResponseBody
	public String showPersonBooks(@RequestParam("id") String pid) {
		System.out.println("in personlist controller - showPersonBooks");
		String result = "";
		Person person = getPerson(pid);
		Set<Book> books = person.getBooks();
		
		for(Book b: books){
	        result += "<li>" + b + "</li>";
			System.out.println("===" + b);
		}
		result = "<ul>" + result + "</ul>";
		ModelAndView mv = new ModelAndView("personbooks");
		mv.addObject("books", books);
		mv.addObject("person", person);
		
		return result;
	}
	/* private List<String> getPersonList(){
		 //List<People> list = this.peopleService.listPeople();
		 List<String> list = new ArrayList<String>();
			list.add("List People A");
			list.add("List People B");
			list.add("List People C");
			list.add("List People D");
			list.add("List People 1");
			list.add("List People 2");
			list.add("List People 3");

			return list;
	 }*/
	 
	 private List<Person> getPersonList(){
		 List<Person> list = this.personService.listPerson();		 
		  return list;

	 }
	 
	 private Person getPerson(String pid){
		 Person person = this.personService.getPerson(pid);		 
		  return person;

	 }
	 
	 @RequestMapping(value="/", method=RequestMethod.GET)
	 public  ModelAndView rootPage(){
		 ModelAndView mv = new ModelAndView("index");
		 mv.addObject("message", message);
		 mv.addObject("rootmessage", rootmessage);
		 return mv;
	 }
}
