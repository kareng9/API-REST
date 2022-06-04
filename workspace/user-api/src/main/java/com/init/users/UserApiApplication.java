package com.init.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiApplication {
//Método main hace una llamada al método run, esta clase se genera por default e inicializa el tomcat.
//No tocar esta clase	
	
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

}
