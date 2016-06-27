package com.nlbookland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nlbookland.dao.PersonDAO;
import com.nlbookland.model.Person;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	@Autowired 
	private PersonDAO personDAO;
	
	public void setPersonDAO(PersonDAO pDAO) {
        this.personDAO = pDAO;
    }
 
	@Override
	public List<Person> listPerson() {		
		return this.personDAO.listPerson();
	}

	@Override
	public Person getPerson(String id) {
		return this.personDAO.getPerson(id);
	}

}
