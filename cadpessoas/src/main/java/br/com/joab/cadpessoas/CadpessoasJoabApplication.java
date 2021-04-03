package br.com.joab.cadpessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan()
public class CadpessoasJoabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadpessoasJoabApplication.class, args);
	}

}
