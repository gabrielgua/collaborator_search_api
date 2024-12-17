package com.erasto.collaborator_search.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    private String credential;
    private String email;
    private String name;
    private BigDecimal salary;
}