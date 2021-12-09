package com.customer.crud.customer.crud.managment.controllers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.customer.crud.customer.crud.managment.dto.CustomerDto;
import com.customer.crud.customer.crud.managment.services.CustomerService;

/**
 * This is REST API Controller class
 * @author Soumen Banerjee
 */
@RestController
@AllArgsConstructor
@RequestMapping("customer/")
public class CustomerController {

    private final CustomerService customerService;

    /**
     *
     * @return this REST API to fetch List of Customers
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    /**
     *
     * @param savecustomer this REST API to create a new customer
     * @return void
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createCustomer(@RequestBody @Validated CustomerDto savecustomer) {
        customerService.createCustomer(savecustomer);
        return ResponseEntity.noContent().build();
    }

    /**
     *
     * @param customerId this REST API to delete an existing customer
     * @return void
     */
    @DeleteMapping(value = "/remove/{customerid}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerid")Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    /**
     *
     * @param savecustomer this REST API to edit a customer
     * @return void
     */
    @PutMapping(value = "/edit")
    public ResponseEntity<Void> updateCustomer(@RequestBody @Validated CustomerDto savecustomer) {
        customerService.updateCustomer(savecustomer);
        return ResponseEntity.noContent().build();
    }

    /**
     *
     * @param customerId this REST API to fetch a single customer
     * @return single customer data
     */
    @GetMapping(value = "/fetchone/{customerid}")
    public ResponseEntity<CustomerDto> getCustomers(@PathVariable("customerid") Long customerId) {
        return ResponseEntity.ok().body(customerService.getOneCustomer(customerId));
    }
}
