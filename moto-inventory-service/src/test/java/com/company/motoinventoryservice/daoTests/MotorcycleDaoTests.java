package com.company.motoinventoryservice.daoTests;


import com.company.motoinventoryservice.dao.MotorcycleDao;
import com.company.motoinventoryservice.dto.Motorcycle;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class MotorcycleDaoTests {

    @Autowired
    protected MotorcycleDao dao;


    private Motorcycle moto;

    @BeforeEach
    public void setUp() throws Exception {
        //Clean database
        dao.deleteAll();

        //Efficient arrange before each
        moto = new Motorcycle();
        moto.setPrice(new BigDecimal("350.00"));
        moto.setColor("Yellow");
        moto.setMake("Subaru");
        moto.setModel("Outback");
        moto.setVin("12345");
        moto.setYear("2016");


    }



    @Test
    public void testGetById() {


        //act
        Motorcycle saved = dao.save(moto);

        Motorcycle found = dao.findById(moto.getId()).orElse(null);

        //assert
        assertEquals(saved, found);

    }

    @Test
    public void testGetAll() {

        /***/
        dao.save(moto);

        List<Motorcycle> found = dao.findAll();

        //assert
        assertEquals(found.size(),1);

    }

    @Test
    public void testSaveMoto() {

        Motorcycle moto2 = dao.save(moto);
        moto.setId(moto2.getId());

        assertEquals(moto,moto2);

    }

    @Test
    public void testUpdateMoto() {


        moto = dao.save(moto);
        moto.setColor("Orange");
        dao.save(moto);
        Motorcycle test = dao.findById(moto.getId()).orElse(null);


        assertEquals(moto,test);


    }


    @Test
    public void testDeleteMoto() {


        dao.save(moto);
        dao.deleteById(moto.getId());

        assertNull(dao.findById(moto.getId()).orElse(null));


    }








}
