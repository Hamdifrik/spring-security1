package app.banque.gestion;


import app.banque.gestion.entities.Client;

import app.banque.gestion.repositorys.ClientRepository;
import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class GestionBanqueApplication {


	public static void main(String[] args) {
		SpringApplication.run(GestionBanqueApplication.class, args);
	}



}