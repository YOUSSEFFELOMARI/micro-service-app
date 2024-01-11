package com.elomari.accountservice.controller;

import com.elomari.accountservice.clients.CustomerRestClient;
import com.elomari.accountservice.entity.Account;
import com.elomari.accountservice.model.Customer;
import com.elomari.accountservice.repository.AccountRepository;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AccountRestController {
    final private AccountRepository accountRepository;
    final private CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<Account> accountList(){
        List<Account> accountList= accountRepository.findAll();
        accountList.forEach(account -> {
            account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        });
        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public Account accountById(@PathVariable String id){
        Account account= accountRepository.findById(id).orElseThrow(NoClassDefFoundError::new);
        Optional<Customer> customer= Optional.ofNullable(customerRestClient.findCustomerById(account.getCustomerId()));
        account.setCustomer(customer.orElseThrow(EntityExistsException::new));
        return account;
    }
}
