package com.school.management;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	System.out.println("project started successfully...");
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
