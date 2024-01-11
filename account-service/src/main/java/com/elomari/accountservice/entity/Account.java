package com.elomari.accountservice.entity;

import com.elomari.accountservice.enums.AccountType;
import com.elomari.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Account {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType Type;
    @Transient
    private Customer customer;
    private Long customerId;
}
