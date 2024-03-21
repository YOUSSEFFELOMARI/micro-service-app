package com.elomari.accountservice.clients;

import com.elomari.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultAllCustomer")
    List<Customer> allCustomers();

    //fallbackMethod = "getDefaultCustomer" transmit un exception a cet method
    default Customer getDefaultCustomer(Long id, Exception exception){
        return Customer.builder()
                .id(id)
                .name("Not Available")
                .lastName("Not Available")
                .email("Not Available")
                .build();
    }

    default List<Customer> getDefaultAllCustomer(Exception exception){
        return Collections.emptyList();
    }
}
