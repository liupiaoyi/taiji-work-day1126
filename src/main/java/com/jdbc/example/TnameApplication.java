package com.jdbc.example;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jdbc.pojo.Tname;
import com.jdbc.service.impl.TnameImpl;

@SpringBootApplication
@ComponentScan("com.jdbc")
public class TnameApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(TnameApplication.class, args);
//	}
	
	@Autowired
	private TnameImpl tNameImpl;
	
	@Test
	public void show() {
			System.out.println(" ---");
			 List<Tname> list = tNameImpl.getList();
			 list.forEach(System.out::println);
		
	}
	
}
