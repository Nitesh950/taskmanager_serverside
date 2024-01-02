package com.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.taskmanager.repository.CustomerRepository;

@SpringBootApplication
public class TaskmanagerServersideApplication implements CommandLineRunner{

	
	@Autowired
	CustomerRepository customerRepository;


	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerServersideApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
	}

}
