package com.customer.crud.customer.crud.managment.entity;

import lombok.Data;
import java.time.LocalDate;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * This is Customer Entity class to fetch and save customer data
 *
 * @author Soumen Banerjee
 */

@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name", nullable = false)
    private String lastname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String passwordHash;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;
}
