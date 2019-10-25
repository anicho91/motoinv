package com.company.MotoInvservice.service;

import com.company.MotoInvservice.util.feign.MotoFeign;
import com.company.MotoInvservice.viewmodel.MotoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    MotoFeign mFeign;

    public MotoViewModel addMoto(MotoViewModel moto){
        return null;
    }

    public List<MotoViewModel> getAllMoto(){
        return null;
    }

    public MotoViewModel getMoto(int id){
        return null;
    }

    public void updateMoto(MotoViewModel moto){

    }

    public void deleteMoto(int id){

    }

    public MotoViewModel purchaseMoto(int id){
        return null;
    }

}
