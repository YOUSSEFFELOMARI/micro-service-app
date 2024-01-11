package com.elomari.customerservice;

import com.elomari.customerservice.entity.Customer;
import com.elomari.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder()
                        .name("youssef1")
                        .lastName("elomari")
                        .email("sda@gm.le")
                        .build(),
                    Customer.builder()
                            .name("youssef2")
                            .lastName("elomari")
                            .email("sda@gm.le")
                            .build(),
                    Customer.builder()
                            .name("youssef3")
                            .lastName("elomari")
                            .email("sda@gm.le")
                            .build()
            ));
        };
    }
}
