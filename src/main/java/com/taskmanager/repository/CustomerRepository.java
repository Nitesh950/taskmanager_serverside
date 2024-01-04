package com.taskmanager.repository;



import java.util.List;

import com.taskmanager.entity.Customer;

public interface CustomerRepository {
    public Customer getCustomerByEmailId(String emailId);
    public void registerCustomer(Customer customer);
    public Object getCustomerEmailAndPassword(String email);
}