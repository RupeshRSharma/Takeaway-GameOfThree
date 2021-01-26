package com.takeaway.player2.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Start up application class
 */
@SpringBootApplication(scanBasePackages = "com.takeaway.player2")
public class Player2ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Player2ServiceApplication.class, args);
	}

}
