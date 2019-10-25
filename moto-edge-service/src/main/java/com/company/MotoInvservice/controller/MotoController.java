package com.company.MotoInvservice.controller;

import com.company.MotoInvservice.viewmodel.MotoViewModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorcycle")
public class MotoController {

    @PostMapping
    public MotoViewModel addMoto(@RequestBody MotoViewModel moto){
        return null;
    }

    @GetMapping
    public List<MotoViewModel> getAllMoto(){
        return null;
    }

    @GetMapping({"/id"})
    public MotoViewModel getMoto(@PathVariable int id){
        return null;
    }

    @PutMapping
    public void updateMoto(@RequestBody MotoViewModel moto){

    }

    @DeleteMapping
    public void deleteMoto(@PathVariable int id){

    }

    @GetMapping({"/purchase/id"})
    public MotoViewModel purchseMoto(@PathVariable int id){
        return null;
    }

}
