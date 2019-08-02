package com.devworld.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devworld.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject the session factory
	// sessionFactory references the bean in the spring config file that includes the data source
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// execute a query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
		
	}

}
