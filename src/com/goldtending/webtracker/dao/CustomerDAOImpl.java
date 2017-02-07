package com.goldtending.webtracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.goldtending.webtracker.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	// remove @Transaction cuz its moved to service layer
	// @Transactional
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
		// create a query make sure to use 5.2 or later hibernate.query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
        		                                                Customer.class);
		
		// get the list of customers from query
        List<Customer> customers = theQuery.getResultList();
		
		// return the list of customers
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save the customer to database
		// change this to saveOrUpdate
		// currentSession.save(theCustomer);
		currentSession.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getCustomers(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now read object from db using id 
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the object with the primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		// execute the query
		theQuery.executeUpdate();
		
	}
	
	

}
