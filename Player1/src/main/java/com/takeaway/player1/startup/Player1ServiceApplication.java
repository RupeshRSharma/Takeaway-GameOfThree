package com.takeaway.player1.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Start up application class
 */
@SpringBootApplication(scanBasePackages = "com.takeaway.player1")
public class Player1ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Player1ServiceApplication.class, args);
	}

}
