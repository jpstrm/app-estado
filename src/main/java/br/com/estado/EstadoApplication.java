package br.com.estado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author João Paulo Santarém
 */
@SpringBootApplication
@EnableJpaAuditing
public class EstadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstadoApplication.class, args);
	}

}
