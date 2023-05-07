package com.wisercat.petmanagement;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisercat.petmanagement.service.PetService;


@RestController
@RequestMapping(value = "/pet")
public class MainController {

    private final PetService petService;

    public MainController(PetService petService) {
        this.petService = petService;
    }

    //to do @GetMapping

}