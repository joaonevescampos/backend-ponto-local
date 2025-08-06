package com.example.backend_ponto_local;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendPontoLocalApplication {

	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        System.setProperty("DB_URL", dotenv.get("DB_URL", "jdbc:postgresql://localhost:5432/ponto_local"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME", "postgres"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD", "postgres"));

        SpringApplication.run(BackendPontoLocalApplication.class, args);
	}

}
