package com.fincons.esercizio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
/*
 * il crossOrigin serve per fare il collegamento al localhost per il frontend
 * /** si mette non sapendo se si collega al local o all app
 */
@CrossOrigin("/**")
public class BootableWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootableWebApplication.class, args);
	}
}
