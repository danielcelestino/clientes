package br.com.daniel;

import br.com.daniel.model.entity.Cliente;
import br.com.daniel.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository clienteRepository){
        return args -> {
            Cliente c1 = Cliente.builder().cpf("01069138169").nome("Fulano").build();
            clienteRepository.save(c1);
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class,args);
    }
}
