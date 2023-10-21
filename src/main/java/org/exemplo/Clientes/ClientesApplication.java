package org.exemplo.Clientes;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientesApplication {


    public static void main(String[] args) {
        SpringApplication Cliente = new SpringApplication(ClientesApplication.class);
        Cliente.run(args);
    }
}
