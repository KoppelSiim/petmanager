package com.wisercat.petmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wisercat.petmanagement.model.Pets;

public interface PetsRepo extends JpaRepository<Pets,Long>{
    
}