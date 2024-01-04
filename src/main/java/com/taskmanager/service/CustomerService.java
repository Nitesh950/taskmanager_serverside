package com.taskmanager.service;

import com.taskmanager.dto.CustomerDTO;


public interface CustomerService {
    public CustomerDTO getCustomer(String emailId);
    public boolean registerCustomer(CustomerDTO customerDTO);
    public boolean customerLogin(String emailId, String password);
}
