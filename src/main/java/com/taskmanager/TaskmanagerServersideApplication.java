package com.taskmanager;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taskmanager.entity.Customer;
import com.taskmanager.repository.CustomerRepository;

@SpringBootApplication
public class TaskmanagerServersideApplication implements CommandLineRunner{
	private static final Log LOGGER = LogFactory.getLog(TaskmanagerServersideApplication.class);
	
	@Autowired
	CustomerRepository customerRepository;


	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerServersideApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
	}

}
