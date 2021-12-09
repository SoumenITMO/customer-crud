package com.customer.crud.customer.crud.managment.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.customer.crud.customer.crud.managment.entity.CustomerEntity;

/**
 * This is a repository interface which will use JPA to access database
 *
 * @author Soumen Banerjee
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> { }
