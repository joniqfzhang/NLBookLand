package com.nlbookland.service;

import java.util.List;
import com.nlbookland.model.Person;

public interface PersonService {
	public List<Person> listPerson();
	public Person getPerson(String id);
}
