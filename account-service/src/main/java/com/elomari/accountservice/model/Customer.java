package com.elomari.accountservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Getter @Setter @ToString @Builder
public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private String email;
}
