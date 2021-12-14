package com.desafio.tecnico.bcp;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioBcpApplication implements CommandLineRunner {

	@Autowired
	ConnectionFactory connectionFactory;

	public static void main(String[] args) {


		SpringApplication.run(DesafioBcpApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		/*ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
		databasePopulator.addScript(new ClassPathResource("data.sql"));
		DatabasePopulatorUtils.execute(databasePopulator, connectionFactory).block();*/
	}
}
