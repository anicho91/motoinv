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
    public Moto addMotocycle(@RequestBody Moto moto);

    @GetMapping
    public List<Moto> getAllMotocycle();

    @GetMapping({"/id"})
    public Moto getMotocycle(@PathVariable int id);

    @PutMapping
    public void updateMotocycle(@RequestBody Moto moto);

    @DeleteMapping
    public void deleteMotocycle(@PathVariable int id);
}
