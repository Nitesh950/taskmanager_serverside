package com.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;

import com.taskmanager.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    
}