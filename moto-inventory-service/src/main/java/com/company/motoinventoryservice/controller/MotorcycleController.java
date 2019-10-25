package com.company.motoinventoryservice.controller;

import com.company.motoinventoryservice.dto.Motorcycle;
import com.company.motoinventoryservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MotorcycleController {


    @Autowired
    ServiceLayer service;

    @RequestMapping(value = "/motorcycle", method = RequestMethod.POST)
    public Motorcycle createMotorcycle(@RequestBody Motorcycle motorcycle) {

        return service.createMotorocyle(motorcycle);

        /**
         * Create
         */
    }

    @RequestMapping(value = "/motorcycle/get/{id}", method = RequestMethod.GET)
    public Motorcycle getMotorcycle(@PathVariable int id) {

        return service.getMotorCycle(id);

    }

    @RequestMapping(value = "/motorcycle", method = RequestMethod.GET)
    public Motorcycle getAllMotorcycle() {
        return null;

        /**
         * getAll
         */

    }

    @RequestMapping(value = "/motorcycle", method = RequestMethod.PUT)
    public void updateMotorcycle(@RequestBody Motorcycle motorcycle) {

        /**
         * update
         */

    }

    @RequestMapping(value = "/motorcycle/delete/{id}", method = RequestMethod.DELETE)
    public void deleteMotorcycle(@PathVariable int id) {

        /**
         * delete
         */

    }








}
