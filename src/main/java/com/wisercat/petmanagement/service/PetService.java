package com.wisercat.petmanagement.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisercat.petmanagement.model.Pets;
import com.wisercat.petmanagement.repo.PetsRepo;

@Service
public class PetService {
    private final PetsRepo petsRepo;

    @Autowired
    public PetService(PetsRepo petsRepo){
        this.petsRepo = petsRepo;
    }
    public Pets addPet(Pets pet){
        pet.setCode(UUID.randomUUID().toString());
        return petsRepo.save(pet);
    }

    public List<Pets> findAllPets(){
        return petsRepo.findAll();
    }
    public Pets updatePet(Pets pet){
        return petsRepo.save(pet);
    }
}