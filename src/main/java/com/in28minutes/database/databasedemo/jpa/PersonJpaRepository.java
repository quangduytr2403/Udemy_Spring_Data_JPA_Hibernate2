package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;


@Repository
@Transactional
public class PersonJpaRepository {
	//connect to database
	@Autowired
	EntityManager entityManager;
	
	public Person findById (int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update (Person person) {
		return entityManager.merge(person);
	}
	
	public Person insert (Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_person", Person.class);
		return namedQuery.getResultList();
	}
}
