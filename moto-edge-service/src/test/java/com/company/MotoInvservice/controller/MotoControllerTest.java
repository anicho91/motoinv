package com.company.MotoInvservice.controller;

import com.company.MotoInvservice.service.MotoService;
import com.company.MotoInvservice.viewmodel.MotoViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MotoController.class)
public class MotoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MotoService service;

    private ObjectMapper mapper = new ObjectMapper();

    static MotoViewModel moto1 = new MotoViewModel(
            0, new BigDecimal("500.00"), "vin num",
            "moto make", "moto model", "1992", "red", new BigDecimal(1161.50)
    );

    static MotoViewModel moto2 = new MotoViewModel(
            1, new BigDecimal("500.00"), "vin num",
            "moto make", "moto model", "1992", "red", new BigDecimal(1161.50)
    );

    @Test
    public void addMoto() throws Exception {
        
        MotoViewModel mvm = moto1;
        
        String inputJson = mapper.writeValueAsString(mvm);
        
        MotoViewModel expected = moto2;
        
        String outputJson = mapper.writeValueAsString(expected);
        
        when(service.addMoto(mvm)).thenReturn(expected);
        
        mockMvc.perform(post("motorcycle")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllMoto() throws Exception {

        MotoViewModel newMoto = moto2;
        List<MotoViewModel> invList = new ArrayList<>();
        invList.add(newMoto);

        String outputJson = mapper.writeValueAsString(invList);

        when(service.getAllMoto()).thenReturn(invList);

        mockMvc.perform(get("/motorcycle"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getMoto() throws Exception {
        MotoViewModel expected = moto2;

        String outputJson = mapper.writeValueAsString(expected);

        when(service.getMoto(1)).thenReturn(expected);

        mockMvc.perform(get("/motorcycle/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateMoto() throws Exception {
        MotoViewModel newMoto = moto1;

        String inputJson = mapper.writeValueAsString(newMoto);

        mockMvc.perform(put("/motorcycle")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteMoto() throws Exception {
        MotoViewModel newMoto = moto1;

        mockMvc.perform(delete("/motorcycle/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void purchaseMoto() throws Exception {

        MotoViewModel expected = moto2;

        String outputJson = mapper.writeValueAsString(expected);

        when(service.purchaseMoto(1)).thenReturn(expected);

        mockMvc.perform(get("/motorcycle/purchase/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }
}