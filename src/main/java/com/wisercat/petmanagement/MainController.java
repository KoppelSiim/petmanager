package com.wisercat.petmanagement;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wisercat.petmanagement.model.Pets;
import com.wisercat.petmanagement.service.PetService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/pet")
public class MainController {

    private final PetService petService;

    public MainController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pets>> getAllPets() {
        List<Pets> pets = petService.findAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Pets> getPetById(@PathVariable("id") Long id) {
        Pets pet = petService.findPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Pets> addPet(@RequestBody Pets pet) {
        Pets newpet = petService.addPet(pet);
        return new ResponseEntity<Pets>(newpet, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Pets> updatePet(@PathVariable("id") Long id, @RequestBody Pets pet) {
        Pets pettoupdate = petService.findPetById(id);
        Pets updatedpet = petService.updatePet(pettoupdate, pet);
        return new ResponseEntity<Pets>(updatedpet, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") Long id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}