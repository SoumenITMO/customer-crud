package com.customer.crud.customer.crud.managment.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import com.customer.crud.customer.crud.managment.dto.CustomerDto;
import com.customer.crud.customer.crud.managment.entity.CustomerEntity;

/**
 * This is a mapper interface, it transform dto to entity and vise versa
 * @author Soumen Banerjee
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    List<CustomerDto> getCustomerDtoList(List<CustomerEntity> customers);
    CustomerDto toDto(CustomerEntity customerEntity);
    CustomerEntity toEntity(CustomerDto customerDto);
    void update(@MappingTarget CustomerEntity user, CustomerDto updatedUser);
}
