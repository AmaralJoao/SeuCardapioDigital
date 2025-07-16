package com.amaral.SeuCardapioDigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SeuCardapioDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeuCardapioDigitalApplication.class, args);

		generateHashedPassword();
	}

	private static void generateHashedPassword() {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String senha1 = passwordEncoder.encode("admin123");
		String senha2 = passwordEncoder.encode("admin234");

		System.out.println("Senha admin123: " + senha1);
		System.out.println("Senha admin234: " + senha2);
	}

}
