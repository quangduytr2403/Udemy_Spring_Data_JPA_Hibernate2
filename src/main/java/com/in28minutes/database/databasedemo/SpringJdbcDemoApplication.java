package com.in28minutes.database.databasedemo;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All User -> {}", dao.findAll());
		logger.info("UserID 10001 -> {}", dao.findById(10001));
		logger.info("DeleteID 10002 -> Row affect -> {}", dao.deleteById(10002));
		logger.info("InsertID 10004 -> {}", dao.insert(new Person(10004, "Tara", 
				"Berlin", LocalDate.now())));
		logger.info("UpdateID 10003 -> {}", dao.update(new Person(10003, "Pieter", 
				"Utrecht", LocalDate.now())));
	}

}
