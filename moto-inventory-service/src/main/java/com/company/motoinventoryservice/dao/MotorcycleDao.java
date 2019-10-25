package com.company.motoinventoryservice.dao;

import com.company.motoinventoryservice.dto.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleDao extends JpaRepository<Motorcycle,Integer> {
}
