package com.company.MotoInvservice.util.feign;

import com.company.MotoInvservice.util.model.Moto;
import com.company.MotoInvservice.viewmodel.MotoViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "moto-service")
@RequestMapping("/motorcycle")
public interface MotoFeign {

    @PostMapping
    public Moto addMoto(@RequestBody Moto moto);

    @GetMapping
    public List<Moto> getAllMoto();

    @GetMapping({"/id"})
    public Moto getMoto(@PathVariable int id);

    @PutMapping
    public void updateMoto(@RequestBody Moto moto);

    @DeleteMapping
    public void deleteMoto(@PathVariable int id);
}
