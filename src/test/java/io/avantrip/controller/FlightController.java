package io.avantrip.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.avantrip.binding.FlightCreateRequest;
import io.avantrip.builders.PaymentBuilder;
import io.avantrip.builders.PersonBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

@ActiveProfiles(value = "test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void successfullyCreateRule() throws Exception {
        FlightCreateRequest request = new FlightCreateRequest();
        request.setScoring(80);
        request.setPersonaBilling(new PersonBuilder().withName("name Billing").withLastName("lastName Billing")
                .withDni("12345678").build());
        request.setPayment(new PaymentBuilder().withDatePurchase(new Date()).withAmount(BigDecimal.valueOf(10.00))
                .withName("TESTTTTT").withNumber("123456787654").build());
        request.setPassengers(Arrays.asList(new PersonBuilder().withName("name Billing")
                .withLastName("lastName Billing").withDni("12345678").build()));
        mockMvc.perform(post("/v1/flight").contentType(MediaType.APPLICATION_JSON).content(asJsonString(request)))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}