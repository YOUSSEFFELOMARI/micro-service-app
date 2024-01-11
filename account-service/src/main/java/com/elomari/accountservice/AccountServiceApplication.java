package com.elomari.accountservice;

import com.elomari.accountservice.clients.CustomerRestClient;
import com.elomari.accountservice.entity.Account;
import com.elomari.accountservice.enums.AccountType;
import com.elomari.accountservice.repository.AccountRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.allCustomers().forEach(customer -> {
				accountRepository.saveAll(List.of(
						Account.builder()
								.accountId(UUID.randomUUID().toString())
								.currency("DH")
								.balance(Math.random())
								.createdAt(LocalDate.now())
								.type(AccountType.CURRENT_ACCOUNT)
								.customerId(customer.getId())
								.build(),
						Account.builder()
								.accountId(UUID.randomUUID().toString())
								.currency("DH")
								.balance(Math.random()*9)
								.createdAt(LocalDate.now())
								.type(AccountType.SAVING_ACCOUNT)
								.customerId(customer.getId())
								.build()
				));
			});
		};
	}
}
