package com.nlbookland.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nlbookland.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPerson() {
		Session session = this.sessionFactory.openSession();
        
		List<Person> personList = session.createQuery("from Person").list();
        for(Person p : personList){
        	System.out.println(p);            
        }
        
		return personList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Person getPerson(String id) {
		Person person = null;
		Session session = this.sessionFactory.openSession();
		String hql = "from Person p where p.id = :person_id";
		Query query = session.createQuery(hql);		
		query.setParameter("person_id", Integer.parseInt(id));
				
		List<Person> results = query.list();
		if (results.size() > 0 ){
			person = results.get(0);
		}
		return person;
	}

}
