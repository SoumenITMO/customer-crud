package com.customer.crud.customer.crud.managment.dto;

import lombok.Data;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

/**
 * This is a Data Transfer Object class which will be
 * used to hold requested data and use it to process
 *
 * @author Soumen Banerjee
 */
@Data
@AllArgsConstructor
public class CustomerDto {

    private Long id;

    @NotNull(message = "Provide customer first name")
    @NotBlank(message = "Provide customer first name")
    private String firstname;

    @NotNull(message = "Provide customer last name")
    @NotBlank(message = "Provide customer last name")
    private String lastname;

    @NotNull(message = "Provide customer username")
    @NotBlank(message =  "Provide customer username")
    private String username;

    @NotNull(message = "Provide birth date")
    private LocalDate birthdate;
}
