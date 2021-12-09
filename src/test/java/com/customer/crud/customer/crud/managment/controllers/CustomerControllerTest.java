package com.customer.crud.customer.crud.managment.controllers;

import java.util.Arrays;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.customer.crud.customer.crud.managment.dto.CustomerDto;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This is a test class which will test main controller of customer
 *
 * @author Soumen Banerjee
 */
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void test_get_all_customer_data_get_method() throws Exception {

        String customerList = mockMvc.perform(MockMvcRequestBuilders
                        .get("/customer/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        CustomerDto[] customersList = mapper.readValue(customerList, CustomerDto[].class);
        CustomerDto getSingleCustomer = Arrays.stream(customersList).findFirst().get();

        assertEquals(getSingleCustomer, new CustomerDto(1L, "Rheta", "Newlan",
                "62yetquqy", LocalDate.of(1988, 12, 11)));
    }

    @Test
    public void test_other_method_does_not_work_except_get_method() throws Exception {
        mockMvc.perform(post("/customer/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void test_for_to_check_create_customer_data_validation() throws Exception {

        assertTrue(mockMvc.perform(post("/customer/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(new CustomerDto(0L, "", "Hello",
                            "78uyt65", LocalDate.now())))
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andReturn().getResponse().getContentAsString()
                    .contains("Provide customer first name"));
    }
}