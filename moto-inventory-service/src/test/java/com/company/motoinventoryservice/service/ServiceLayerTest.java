package com.company.motoinventoryservice.service;

import com.company.motoinventoryservice.dao.MotorcycleDao;
import com.company.motoinventoryservice.dto.Motorcycle;
import org.apache.commons.lang.ObjectUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceLayerTest {

    MotorcycleDao dao;
    ServiceLayer service;
    Motorcycle moto;


    @BeforeEach
    void setUp() {

        createMock();

        service = new ServiceLayer(dao);

        moto = new Motorcycle();
        moto.setPrice(new BigDecimal("350.00"));
        moto.setColor("Yellow");
        moto.setMake("Subaru");
        moto.setModel("Outback");
        moto.setVin("12345");
        moto.setYear("2016");

    }

    @Test
    void getMotorCycle() {

        moto = service.createMotorocyle(moto);

        Motorcycle testMoto = service.getMotorCycle(moto.getId());

        assertEquals(moto,testMoto);

    }

    @Test
    void getAllMotorcycles() {

        moto = service.createMotorocyle(moto);

        assertEquals(dao.findAll().size(),1);

    }

    @Test
    void createMotorocyle() {
        Motorcycle test = service.createMotorocyle(moto);

        moto.setId(test.getId());

        assertEquals(moto,test);

    }

    @Test
    void updateMotorcycle() {

        moto = service.createMotorocyle(moto);

        moto.setColor("Blue");

        service.updateMotorcycle(moto);


        assertEquals(dao.getOne(moto.getId()), moto);


    }

    @Test
    void deleteMotorCycle() {

        moto = service.createMotorocyle(moto);

        dao.deleteById(moto.getId());

        assertNull(service.getMotorCycle(moto.getId()));





    }

    public void createMock() {

        dao = mock(MotorcycleDao.class);

        Motorcycle moto = new Motorcycle();
        moto.setPrice(new BigDecimal("350.00"));
        moto.setColor("Yellow");
        moto.setMake("Subaru");
        moto.setModel("Outback");
        moto.setVin("12345");
        moto.setYear("2016");

        Motorcycle outputMoto = new Motorcycle();
        outputMoto.setId(1);
        outputMoto.setPrice(new BigDecimal("350.00"));
        outputMoto.setColor("Yellow");
        outputMoto.setMake("Subaru");
        outputMoto.setModel("Outback");
        outputMoto.setVin("12345");
        outputMoto.setYear("2016");

        List<Motorcycle> list = new ArrayList<>();
        list.add(outputMoto);

        doReturn(outputMoto).when(dao).save(moto);
        doReturn(outputMoto).when(dao).getOne(1);
        doReturn(list).when(dao).findAll();


    }


}