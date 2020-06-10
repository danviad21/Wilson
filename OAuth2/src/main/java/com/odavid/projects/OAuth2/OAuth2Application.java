package com.odavid.projects.OAuth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OAuth2Application implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(OAuth2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String password = "12345";
		
		for(int i=0; i<4; i++) {
			String passwordEncriptado = this.bCryptPasswordEncoder.encode(password);
			System.out.println(passwordEncriptado);
		}
		
	}

}
