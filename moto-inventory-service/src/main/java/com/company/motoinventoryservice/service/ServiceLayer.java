package com.company.motoinventoryservice.service;

import com.company.motoinventoryservice.dao.MotorcycleDao;
import com.company.motoinventoryservice.dto.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceLayer {

    private MotorcycleDao dao;


    @Autowired
    public ServiceLayer(MotorcycleDao dao) {
        this.dao = dao;
    }

    public Motorcycle getMotorCycle(int id) {return dao.getOne(id);}

    public List<Motorcycle> getAllMotorcycles() {return null;}

    public Motorcycle createMotorocyle(Motorcycle motorcycle) {return dao.save(motorcycle);}

    public void updateMotorcycle(Motorcycle motorcycle) {dao.save(motorcycle);}

    public void deleteMotorCycle(int id){dao.deleteById(id);}


}
