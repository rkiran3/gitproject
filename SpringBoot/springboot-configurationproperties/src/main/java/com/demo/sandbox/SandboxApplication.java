package com.demo.sandbox;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SandboxApplication {

	@Autowired
	AppInfo appInfo;
	
	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}

	@PostConstruct()
	public void dump() {
		System.out.println("In Post ==> ");
		System.out.println(appInfo);
	}
}
