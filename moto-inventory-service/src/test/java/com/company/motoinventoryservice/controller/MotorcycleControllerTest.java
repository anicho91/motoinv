package com.company.motoinventoryservice.controller;

import com.company.motoinventoryservice.dto.Motorcycle;
import com.company.motoinventoryservice.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.sql.DataSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MotorcycleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer service;

    @MockBean
    private DataSource data;

    private ObjectMapper mapper = new ObjectMapper();

    private Motorcycle moto, outputMoto;


    //ControllerTests

    @BeforeEach
    void setUp() {


        moto = new Motorcycle();
        moto.setPrice(new BigDecimal("350.00"));
        moto.setColor("Yellow");
        moto.setMake("Subaru");
        moto.setModel("Outback");
        moto.setVin("12345");
        moto.setYear("2016");

        outputMoto = new Motorcycle();
        outputMoto.setId(1);
        outputMoto.setPrice(new BigDecimal("350.00"));
        outputMoto.setColor("Yellow");
        outputMoto.setMake("Subaru");
        outputMoto.setModel("Outback");
        outputMoto.setVin("12345");
        outputMoto.setYear("2016");


    }

    @Test
    void createMotorcycle() throws Exception  {



        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(moto);


        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputMoto);

        when(service.createMotorocyle(moto)).thenReturn(outputMoto);



        this.mockMvc.perform(post("/inventory")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(content().json(outputJson));


    }

    @Test
    void getMotorcycle() throws Exception {

        String outputJson = mapper.writeValueAsString(outputMoto);

        // Mocking DAO response
        // This is another way to mock using mockito
        // same as doReturn(returnVal).when(repo).findById(8);
        // We could also set up our mocks in a separate method, if we so chose
        doReturn(outputMoto).when(service).getMotorCycle(6);


        this.mockMvc.perform(get("/motorcycle/get/6"))
                .andDo(print())
                .andExpect(content().json(outputJson));
    }

    @Test
    void getAllMotorcycle() {
    }

    @Test
    void updateMotorcycle() {
    }

    @Test
    void deleteMotorcycle() {
    }
}