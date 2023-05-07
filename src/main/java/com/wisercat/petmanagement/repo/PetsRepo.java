package com.wisercat.petmanagement.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wisercat.petmanagement.model.Pets;

public interface PetsRepo extends JpaRepository<Pets, Long> {

    Optional<Pets> findPetById(Long id);

    void deletePetById(Long id);
}