package com.taskmanager.repository.impl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.taskmanager.entity.Customer;
import com.taskmanager.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CustomerRepositoryIMPL implements CustomerRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Customer getCustomerByEmailId(String emailId) {
        String queryString = "SELECT c FROM Customer c WHERE c.emailId=:emailId";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("emailId", emailId);
        List<Customer> customerList =  query.getResultList();
        if(customerList.isEmpty()){
            return null;
        }
        return customerList.get(0);
    }

    @Override
    public void registerCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Object getCustomerEmailAndPassword(String emailId) {
        String queryString = "select c.password from Customer c where c.emailId=:emailId";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("emailId", emailId);
        Object emailAndPassword = query.getSingleResult();
        if(emailAndPassword == null){
            return null;
        }
        return emailAndPassword;
    }


    
}
