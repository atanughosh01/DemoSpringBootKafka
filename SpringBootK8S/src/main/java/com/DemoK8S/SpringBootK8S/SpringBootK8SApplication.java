package com.DemoK8S.SpringBootK8S;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootK8SApplication {

	@GetMapping("/")
	public String homePage() {
		System.out.println("Home page is up and running");
		return "Spring Boot Kubernetes Demo !!";
	}

	@GetMapping("/message")
	public String displayMessage() {
		System.out.println("displayMessage() called");
		return "Congratulations, you've successfully deployed your application to kubernetes !!";
	}

	public static void main(String[] args) {
		// Main class
		SpringApplication.run(SpringBootK8SApplication.class, args);
	}
}
