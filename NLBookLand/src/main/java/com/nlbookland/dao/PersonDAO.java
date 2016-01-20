package com.nlbookland.dao;

import java.util.List;

import com.nlbookland.model.Person;

public interface PersonDAO {
	public List<Person> listPerson();
	public Person getPerson(String id);
}
