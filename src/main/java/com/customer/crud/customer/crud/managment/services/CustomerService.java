package com.customer.crud.customer.crud.managment.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.customer.crud.customer.crud.managment.dto.CustomerDto;
import com.customer.crud.customer.crud.managment.mapper.CustomerMapper;
import com.customer.crud.customer.crud.managment.entity.CustomerEntity;
import com.customer.crud.customer.crud.managment.repository.CustomerRepository;

/**
 * This is main customer service class where data processing happen and return to controller
 *
 * @author Soumen Banerjee
 */
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    /**
     *
     * @return List of customer Dto
     */
    public List<CustomerDto> getAllCustomers() {
        return customerMapper.getCustomerDtoList(customerRepository.findAll());
    }

    /**
     *
     * @param customerId
     * @return it returns single Customer data
     */
    public CustomerDto getOneCustomer(Long customerId) {
        return customerMapper.toDto(customerRepository.findById(customerId).get());
    }

    /**
     *
     * @param customerDto this is a new customer create method
     */
    public void createCustomer(CustomerDto customerDto) {
        customerRepository.save(customerMapper.toEntity(customerDto));
    }

    /**
     *
     * @param customerDto this is a update method up update customer data
     */
    public void updateCustomer(CustomerDto customerDto) {
        CustomerEntity getCustomer = customerRepository.findById(customerDto.getId()).get();
        customerMapper.update(getCustomer, customerDto);
        customerRepository.save(customerMapper.toEntity(customerDto));
    }

    /**
     *
     * @param customerId this method to delete an existing customer
     */
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
