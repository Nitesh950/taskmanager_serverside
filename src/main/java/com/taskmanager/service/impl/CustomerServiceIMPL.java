package com.taskmanager.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.dto.CustomerDTO;
import com.taskmanager.entity.Customer;
import com.taskmanager.repository.CustomerRepository;
import com.taskmanager.service.CustomerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerDTO getCustomer(String emailId) {
        Customer customer = customerRepository.getCustomerByEmailId(emailId);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());

        return customerDTO;
        
    }

    @Override
    public boolean registerCustomer(CustomerDTO customerDTO) {
        Customer customerInfo = customerRepository.getCustomerByEmailId(customerDTO.getEmailId());
        if(customerInfo != null){
            System.out.println("\n\n Customer already exists with email Id: " + customerInfo.getEmailId());
            return false;
        }
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setName(customerDTO.getName());
        customer.setEmailId(customerDTO.getEmailId());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        String encryptedPassword = encryptPass(customerDTO.getPassword());
        customer.setPassword(encryptedPassword);

        customerRepository.registerCustomer(customer);

        System.out.println("\n\n Successfully registered customer");
        return true;
    }



    private String encryptPass(String password) {
        try {
            //retrieve instance of the encryptor of SHA-256
            MessageDigest digestor = MessageDigest.getInstance("SHA-256");
            //retrieve bytes to encrypt
            byte[] encodedhash = digestor.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder encryptionValue = new StringBuilder(2 * encodedhash.length);
            //perform encryption
            for (int i = 0; i < encodedhash.length; i++) {
                String hexVal = Integer.toHexString(0xff & encodedhash[i]);
                if (hexVal.length() == 1) {
                    encryptionValue.append('0');
                }
                encryptionValue.append(hexVal);
            }
            //return encrypted value
            return encryptionValue.toString();
            } catch (Exception ex) {
                return ex.getMessage();
            }
    }

    @Override
    public boolean customerLogin(String emailId, String password) {
        Object customerCredentials = customerRepository.getCustomerEmailAndPassword(emailId);
        String customerPassword = customerCredentials.toString();
        if(customerPassword == null){
            System.out.println("\n\n No customer records found. Please register");
            return false;
        }

        if(encryptPass(password).equals(customerPassword)){
            System.out.println("\n\n Login Successful");
            return true;
        }else{
            System.out.println("\n\n Login Failed");
            return false;
        }
    }

}
