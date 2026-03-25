package com.Flavio.byshop;

// importação da classe SpringApplication para iniciar a aplicação Spring Boot
import org.springframework.boot.SpringApplication;

// importação da anotação que marca a classe como aplicação Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;

// anotação que marca esta classe como a classe principal de uma aplicação Spring Boot
// combine as funcionalidades de:
//   @Configuration: define a classe como fonte de definições de beans
//   @EnableAutoConfiguration: ativa a auto-configuração do Spring Boot
//   @ComponentScan: permite que o Spring procure por componentes no pacote e subpacotes
@SpringBootApplication
public class ByshopApplication {

	// método main é o ponto de entrada da aplicação
	// este método é executado quando a aplicação é iniciada
	// args: argumentos de linha de comando passados à aplicação
	public static void main(String[] args) {
		// inicia a aplicação Spring Boot
		// SpringApplication.run():
		//   - cria um novo contexto da aplicação
		//   - inicializa todos os beans configurados
		//   - inicia o servidor (tomcat por padrão)
		//   - deixa a aplicação rodando até ser interrompida (Ctrl+C)
		SpringApplication.run(ByshopApplication.class, args);
	}

}
