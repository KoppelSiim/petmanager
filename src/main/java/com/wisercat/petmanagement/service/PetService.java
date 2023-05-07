package com.wisercat.petmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisercat.petmanagement.exception.PetNotFoundExeption;
import com.wisercat.petmanagement.model.Pets;
import com.wisercat.petmanagement.repo.PetsRepo;

@Service
public class PetService {
    private final PetsRepo petsRepo;

    @Autowired
    public PetService(PetsRepo petsRepo) {
        this.petsRepo = petsRepo;
    }

    // Add a new pet to database
    public Pets addPet(Pets pet) {
        return petsRepo.save(pet);
    }

    // Get a json formatted list of all the pets
    public List<Pets> findAllPets() {
        return petsRepo.findAll();
    }

    // Get pet by id or throw an exeption if it does not exist
    public Pets findPetById(Long id) {
        return petsRepo.findPetById(id)
                .orElseThrow(() -> new PetNotFoundExeption("Pet by id " + id + " not found"));
    }

    // Takes two parameters: the pet we need to update and new data
    public Pets updatePet(Pets pettoupdate, Pets pet) {
        pettoupdate.setPetName(pet.getPetName());
        pettoupdate.setCode(pet.getCode());
        pettoupdate.setPetType(pet.getPetType());
        pettoupdate.setFurColor(pet.getFurColor());
        pettoupdate.setCountry(pet.getCountry());
        return petsRepo.save(pettoupdate);
    }

    // Delete pet or throw an exeption if pet does not exist
    public void deletePet(Long id) throws PetNotFoundExeption {
        Optional<Pets> pet = petsRepo.findPetById(id);
        if (pet == null) {
            throw new PetNotFoundExeption("Pet with id" + id + " does not exist");
        }
        petsRepo.deleteById(id);

    }
}