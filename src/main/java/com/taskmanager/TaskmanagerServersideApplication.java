package com.taskmanager;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taskmanager.dto.CustomerDTO;
import com.taskmanager.service.CustomerService;

@SpringBootApplication
public class TaskmanagerServersideApplication implements CommandLineRunner{

	
	@Autowired
	CustomerService customerService;


	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerServersideApplication.class, args);
	}

	public void run(String... args) throws Exception {
		CustomerDTO customer = new CustomerDTO(2, "marty@infy.com", "Marty", "Marty@123", LocalDate.of(1998, 02, 05));
		boolean isRegistrationSuccessful = customerService.registerCustomer(customer);
		if(isRegistrationSuccessful){
			System.out.println("\n\n Successfully registered customer.\n\n");
		}

		customerService.customerLogin("marty@infy.com", "Marty@123");

		
	}

}
